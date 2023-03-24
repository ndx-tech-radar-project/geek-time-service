package com.example.demo.domain.modle.Course;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseCollectionRequest {
    private Long userId;
    private Long courseId;
    private Integer isCollection;

}
