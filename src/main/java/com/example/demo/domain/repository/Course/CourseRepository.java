package com.example.demo.domain.repository.Course;

import com.example.demo.domain.modle.Course.Course;
import com.example.demo.domain.modle.Course.CourseCollectionRequest;

import java.util.List;

public interface CourseRepository {

    List<Course> findAll();

    boolean createCourse(Course course);

    boolean updateCourse(Course course);

    boolean deleteCourseById(Long id);

    boolean collectionCourse(CourseCollectionRequest courseCollectionRequest);
}
