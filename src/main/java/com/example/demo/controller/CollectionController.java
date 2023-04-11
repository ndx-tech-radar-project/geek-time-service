package com.example.demo.controller;

import com.example.demo.domain.modle.Collection.Collection;
import com.example.demo.domain.modle.Course.Course;
import com.example.demo.domain.service.CollectionService;
import com.example.demo.web.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CollectionController {

    @Autowired
    public CollectionService collectionService;

    @PostMapping("/api/course/collection")
    public Result<?> collectionCourse(@RequestBody Collection collection) {
        boolean result = collectionService.collectionCourse(collection);
        if (result) {
            return Result.ok().build();
        } else {
            return Result.error().build();
        }
    }

    @GetMapping("/api/course/collection")
    public Result<List<Course>> findAllCollectionCourses(@RequestBody Collection collection) {
        Result.ResultBuilder<List<Course>> result = Result.ok();
        List<Course> courses = collectionService.findAllCollectionCoursesByUserId(collection.getUserId());
        return result.data(courses).build();
    }
}
