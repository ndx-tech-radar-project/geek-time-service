package com.example.demo.domain.repository.Course;

import com.example.demo.domain.modle.Course.Course;

import java.util.List;

public interface CourseRepository {

    List<Course> findAll();
}
