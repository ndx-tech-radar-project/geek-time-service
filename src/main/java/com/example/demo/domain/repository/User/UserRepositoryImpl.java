package com.example.demo.domain.repository.User;

import com.example.demo.domain.mapper.UserMapper;
import com.example.demo.domain.modle.User.User;
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

    @Override
    public Boolean createUser(User user) {
        return userRepositoryJpa.save(UserMapper.MAPPER.toEntity(user)) != null;
    }

    @Override
    public Boolean updateUser(User user) {
        return userRepositoryJpa.save(UserMapper.MAPPER.toEntity(user)) != null;
    }

    @Override
    public Boolean deleteUser(Long id) {
        userRepositoryJpa.deleteById(id);
        return true;
    }

    @Override
    public boolean exist(String name) {
        return userRepositoryJpa.existsByName(name);
    }

}
