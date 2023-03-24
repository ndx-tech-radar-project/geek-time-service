package com.example.demo.domain.repository.User;

import com.example.demo.domain.Entity.UserEntity;
import com.example.demo.domain.modle.User.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> findAll();

    Boolean createUser(User user);

    Boolean updateUser(User user);

    Boolean deleteUser(Long id);

    boolean exist(String name);

    User findByName(String name);

    User findById(Long valueOf);
}
