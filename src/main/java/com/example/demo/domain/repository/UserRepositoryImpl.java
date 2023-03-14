package com.example.demo.domain.repository;

import com.example.demo.domain.mapper.UserMapper;
import com.example.demo.domain.modle.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserRepositoryJpa userRepositoryJpa;


    @Override
    public List<User> findAll() {
        return UserMapper.MAPPER.toModel(userRepositoryJpa.findAll());
    }
}
