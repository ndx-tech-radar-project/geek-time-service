package com.example.demo.controller;

import com.example.demo.domain.modle.User.User;
import com.example.demo.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping("/api/user")
    public List<User> findAll() {
        return userService.findAll();
    }

}
