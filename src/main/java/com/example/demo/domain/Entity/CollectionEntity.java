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
@Table(name = "course_collection")
@Where(clause = BaseEntity.SKIP_DELETED_CLAUSE)
@SQLDelete(sql = "update course_collection set deleted = true where id =? and version = ?")
public class CollectionEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "is_collection")
    private Integer isCollection;

}
