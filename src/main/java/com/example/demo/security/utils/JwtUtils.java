package com.example.demo.security.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;
import java.util.Date;

@Getter
@Setter
@Component
public class JwtUtils {

    @Value("${authorization.jwt.secret}")
    private String secret;
    @Value("${authorization.jwt.expires}")
    private long expirationTime;

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
}
