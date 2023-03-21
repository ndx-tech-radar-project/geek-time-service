package com.example.demo.domain.modle.Course;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private Long id;
    private String courseName;
    private String courseType;
    private String courseIntroduction;
    private Float price;
    private Integer termOfValidity;
}
