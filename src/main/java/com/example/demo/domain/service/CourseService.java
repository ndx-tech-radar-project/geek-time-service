package com.example.demo.domain.service;

import com.example.demo.domain.modle.Course.Course;
import com.example.demo.domain.modle.Course.CourseCollectionRequest;
import com.example.demo.domain.repository.Collection.CollectionRepository;
import com.example.demo.domain.repository.Course.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    private final CollectionRepository collectionRepository;

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public boolean createCourse(Course course) {
        return courseRepository.createCourse(course);
    }

    public boolean updateCourse(Course course) {
        return courseRepository.updateCourse(course);
    }

    public boolean deleteCourse(Long id) {
        return courseRepository.deleteCourseById(id);
    }

}
