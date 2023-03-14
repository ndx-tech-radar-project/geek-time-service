package com.example.demo.domain.repository.User;

import com.example.demo.domain.modle.User.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();
}
