package com.example.demo.domain.modle.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String name;
    private int age;
    private String email;
    private Long classId;
    private String createdAt;
    private String nickname;
    private String password;
    private String role;

}
