package com.example.demo.domain.repository;

import com.example.demo.domain.modle.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository userJpaRepository;


    @Override
    public List<User> findAll() {
        User user1 = new User(1L, "user1", 12, "137836@qq.com", 2L);
//        memberJpaRepository.save(memberEntity);
//        return userJpaRepository.findAll();
        return List.of(user1);
    }
}
