package com.example.demo.controller;

import com.example.demo.domain.modle.Collection.Collection;
import com.example.demo.domain.service.CollectionService;
import com.example.demo.web.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
