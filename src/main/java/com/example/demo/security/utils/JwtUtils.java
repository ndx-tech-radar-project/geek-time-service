package com.example.demo.security.utils;

import com.example.demo.domain.Entity.UserEntity;
import com.example.demo.domain.modle.User.User;
import com.example.demo.domain.repository.User.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

@Getter
@Setter
@Component
public class JwtUtils {

    @Value("${authorization.jwt.secret}")
    private String secret;
    @Value("${authorization.jwt.expires}")
    private long expirationTime;

    @Autowired
    private UserRepository userRepository;

    public String createJwtToken(Long id, String role, String username) {
        return Jwts.builder()
                .setId(String.valueOf(id))
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(SignatureAlgorithm.HS512, secret.getBytes(Charset.defaultCharset()))
                .compact();
    }

    public Claims parseJwtToken(String jwt) {
        return Jwts
                .parser()
                .setSigningKey(secret.getBytes(Charset.defaultCharset()))
                .parseClaimsJws(jwt)
                .getBody();
    }

    public User getEntityOptional(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        try {
            String token = Arrays.stream(cookies)
                    .filter(cookie -> cookie.getName().equals("token"))
                    .findFirst().get().getValue();

            Claims claims = parseJwtToken(token);
            String id = claims.getId();
            return userRepository.findById(Long.valueOf(id));
        } catch (Exception e) {
            return null;
        }
    }
}
