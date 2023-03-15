package com.example.demo.domain.Entity;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

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

    private String name;

    private int age;

    private String email;

    @Column(name = "class_id")
    private Long classId;
}
