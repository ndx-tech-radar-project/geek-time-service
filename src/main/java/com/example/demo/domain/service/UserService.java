package com.example.demo.domain.service;

import com.example.demo.domain.mapper.UserMapper;
import com.example.demo.domain.modle.User.User;
import com.example.demo.domain.modle.User.UserRegisterRequest;
import com.example.demo.domain.repository.User.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;
import java.util.Objects;

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

    public Boolean requestUser(UserRegisterRequest userRegisterRequest) {
        validateForRegister(userRegisterRequest);

        User newUser = UserMapper.MAPPER.toModel(userRegisterRequest);
        newUser.setNickname(userRegisterRequest.getName());
        newUser.setPassword(DigestUtils.md5DigestAsHex(userRegisterRequest.getPassword().getBytes()));
        return userRepository.createUser(newUser);
    }

    private void validateForRegister(UserRegisterRequest request) {
        if (userRepository.exist(request.getName())) {
            throw new RuntimeException("User already exists");
        }
    }

    public Boolean login(UserRegisterRequest userRegisterRequest) {
        User user = userRepository.findByName(userRegisterRequest.getName());
        if (Objects.isNull(user)) {
            throw new RuntimeException("User not exists");
        }
        String password = userRegisterRequest.getPassword();
        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!user.getPassword().equals(md5Password)) {
            throw new RuntimeException("Password not correct");
        }
        return true;
    }

}
