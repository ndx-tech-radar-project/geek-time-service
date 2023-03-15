package com.example.demo.controller;

import com.example.demo.domain.modle.User.User;
import com.example.demo.domain.service.UserService;
import com.example.demo.web.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Result<?> createUser(User user) {
        return Result.ok().build();
    }

}
