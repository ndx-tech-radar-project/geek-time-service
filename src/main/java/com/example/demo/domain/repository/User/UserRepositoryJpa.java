package com.example.demo.domain.repository.User;

import com.example.demo.domain.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryJpa extends JpaRepository<UserEntity, Long> {
    boolean existsByName(String name);

    UserEntity findByName(String name);
}
