package com.example.demo.domain.Entity;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
@Where(clause = BaseEntity.SKIP_DELETED_CLAUSE)
@SQLDelete(sql = "update user set deleted = true where id =? and version = ?")
public class UserEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", length = 16)
    private String name;

    private int age;

    private String email;

    @Column(name = "class_id")
    private Long classId;

    @Column(length = 60)
    private String password;

    private String role;

    @Column(name = "nick_name")
    private String nickname;
}
