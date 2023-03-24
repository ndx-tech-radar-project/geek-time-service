package com.example.demo.controller;

import com.example.demo.domain.Entity.UserEntity;
import com.example.demo.domain.modle.Course.Course;
import com.example.demo.domain.modle.Course.CourseCollectionRequest;
import com.example.demo.domain.modle.User.User;
import com.example.demo.domain.service.CourseService;
import com.example.demo.security.utils.JwtUtils;
import com.example.demo.web.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    public CourseService courseService;

    @Autowired
    public JwtUtils jwtUtils;

    @GetMapping("/api/course")
    public Result<List<Course>> findAllCourses() {
        Result.ResultBuilder<List<Course>> result = Result.ok();
        List<Course> courses = courseService.findAll();
        return result.data(courses).build();
    }

    @PostMapping("/api/course")
    public Result<?> createCourse(@RequestBody Course course) {
        boolean result = courseService.createCourse(course);
        if (result) {
            return Result.ok().build();
        } else {
            return Result.error().build();
        }
    }

    @PutMapping("/api/course/{id}")
    public Result<?> updateCourse(@PathVariable("id") Long id, @RequestBody Course course) {
        course.setId(id);
        boolean result = courseService.updateCourse(course);
        if (result) {
            return Result.ok().build();
        } else {
            return Result.error().build();
        }
    }

    @DeleteMapping("/api/course/{id}")
    public Result<?> deleteCourse(@PathVariable("id") Long id) {
        boolean result = courseService.deleteCourse(id);
        if (result) {
            return Result.ok().build();
        } else {
            return Result.error().build();
        }
    }


}
