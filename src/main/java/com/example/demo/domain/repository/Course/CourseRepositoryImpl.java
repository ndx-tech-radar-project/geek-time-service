package com.example.demo.domain.repository.Course;

import com.example.demo.domain.modle.Course.Course;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import com.example.demo.domain.mapper.CourseMapper;


import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CourseRepositoryImpl implements CourseRepository {


    private final CourseRepositoryJpa courseRepositoryJpa;

    @Override
    public List<Course> findAll() {
        return CourseMapper.MAPPER.toModel(courseRepositoryJpa.findAll());
    }

    @Override
    public boolean createCourse(Course course) {
        return courseRepositoryJpa.save(CourseMapper.MAPPER.toEntity(course)) != null;
    }

    @Override
    public boolean updateCourse(Course course) {
        return courseRepositoryJpa.save(CourseMapper.MAPPER.toEntity(course)) != null;
    }

    @Override
    public boolean deleteCourseById(Long id) {
        try {
            courseRepositoryJpa.deleteById(id);
            return true;
        } catch (Exception e) {
            log.error("delete course error", e);
            return false;
        }
    }
}
