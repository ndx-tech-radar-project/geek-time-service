package com.example.demo.controller;

import com.example.demo.domain.modle.User.User;
import com.example.demo.domain.modle.User.UserLoginRequest;
import com.example.demo.domain.service.UserService;
import com.example.demo.web.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    public UserService userService;

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
        Boolean result = userService.login(userLoginRequest);
        if (result) {
            return Result.ok().build();
        } else {
            return Result.error().build();
        }
    }

}
