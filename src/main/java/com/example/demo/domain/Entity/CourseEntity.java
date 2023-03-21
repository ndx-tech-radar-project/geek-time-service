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
@Table(name = "course")
@Where(clause = BaseEntity.SKIP_DELETED_CLAUSE)
@SQLDelete(sql = "update course set deleted = true where id =? and version = ?")
public class CourseEntity extends BaseEntity{
    @Id
    private Long id;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "course_type")
    private Integer courseType;

    @Column(name = "course_introduction")
    private String courseIntroduction;

    private Float price;

    @Column(name = "term_of_validity")
    private Integer termOfValidity;
}
