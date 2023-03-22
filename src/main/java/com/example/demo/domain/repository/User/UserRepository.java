package com.example.demo.domain.repository.User;

import com.example.demo.domain.modle.User.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();

    Boolean createUser(User user);

    Boolean updateUser(User user);

    Boolean deleteUser(Long id);

    boolean exist(String name);

    User findByName(String name);
}
