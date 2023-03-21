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
public class CourseRepositoryImpl implements CourseRepository{


    private final CourseRepositoryJpa courseRepositoryJpa;

    @Override
    public List<Course> findAll() {
        return CourseMapper.MAPPER.toModel(courseRepositoryJpa.findAll());
    }
}
