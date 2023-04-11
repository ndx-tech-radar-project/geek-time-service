package com.example.demo.domain.service;

import com.example.demo.domain.modle.Collection.Collection;
import com.example.demo.domain.modle.Course.Course;
import com.example.demo.domain.repository.Collection.CollectionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CollectionService {

    private final CollectionRepository collectionRepository;

    public boolean collectionCourse(Collection collection) {
        return collectionRepository.collectionCourse(collection);
    }

    public Collection getCollectionByUserIdAndCourseId(Long userId, Long courseId) {
        return collectionRepository.getCollectionByUserIdAndCourseId(userId, courseId);
    }


    public List<Course> findAllCollectionCoursesByUserId(Long userId) {
        return collectionRepository.findCollectionCoursesByUserId(Long.valueOf(userId));
    }
}
