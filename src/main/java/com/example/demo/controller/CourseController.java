package com.example.demo.controller;

import com.example.demo.domain.modle.Course.Course;
import com.example.demo.domain.service.CourseService;
import com.example.demo.web.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    public CourseService courseService;

    @GetMapping("/api/course")
    public Result<List<Course>> findAllCourses() {
        Result.ResultBuilder<List<Course>> result = Result.ok();
        List<Course> courses = courseService.findAll();
        return result.data(courses).build();
    }
}
