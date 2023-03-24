package com.example.demo.controller;

import com.example.demo.domain.modle.User.User;
import com.example.demo.domain.modle.User.UserLoginRequest;
import com.example.demo.domain.service.UserService;
import com.example.demo.security.utils.JwtUtils;
import com.example.demo.web.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

@RestController
public class UserController {

    @Autowired
    public UserService userService;

    @Autowired
    private JwtUtils jwtUtils;

    @GetMapping("/api/user")
    public Result<List<User>> findAllUsers() {
        Result.ResultBuilder<List<User>> result = Result.ok();
        List<User> users = userService.findAll();
        return result.data(users).build();
    }

    @PostMapping("/api/user")
    public Result<?> createUser(@RequestBody User user) {
        Boolean result = userService.createUser(user);
        if (result) {
            return Result.ok().build();
        } else {
            return Result.error().build();
        }
    }

    @PutMapping("/api/user/{id}")
    public Result<?> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        user.setId(id);
        Boolean result = userService.updateUser(user);
        if (result) {
            return Result.ok().build();
        } else {
            return Result.error().build();
        }
    }

    @DeleteMapping("/api/user/{id}")
    public Result<?> deleteUser(@PathVariable("id") Long id) {
        Boolean result = userService.deleteUser(id);
        if (result) {
            return Result.ok().build();
        } else {
            return Result.error().build();
        }
    }

    @PostMapping("/api/user/register")
    public Result<?> requestUser(@RequestBody UserLoginRequest userLoginRequest) {
        Boolean result = userService.requestUser(userLoginRequest);
        if (result) {
            return Result.ok().build();
        } else {
            return Result.error().build();
        }
    }

    @PostMapping("/api/user/login")
    public Result<?> login(@RequestBody UserLoginRequest userLoginRequest, HttpServletRequest request) {
        User user = userService.findByName(userLoginRequest.getName());
        if (Objects.isNull(user)) {
            return Result.error("用户不存在").build();
        }
        String password = userLoginRequest.getPassword();
        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!user.getPassword().equals(md5Password)) {
            return Result.error("密码错误").build();
        }
        String token = jwtUtils.createJwtToken(user.getId(), user.getRole(), user.getName());
        request.getSession().setAttribute("token", token);
        return Result.ok(token).build();
    }

}
