package com.example.demo.domain.service;

import com.example.demo.domain.modle.User.User;
import com.example.demo.domain.repository.User.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Boolean createUser(User user) {
        return userRepository.createUser(user);
    }

    public Boolean updateUser(User user) {
        return userRepository.updateUser(user);
    }

    public Boolean deleteUser(Long id) {
        return userRepository.deleteUser(id);
    }
}
