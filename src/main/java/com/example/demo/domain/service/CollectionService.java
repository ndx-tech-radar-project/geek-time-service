package com.example.demo.domain.service;

import com.example.demo.domain.modle.Collection.Collection;
import com.example.demo.domain.repository.Collection.CollectionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CollectionService {

    private final CollectionRepository collectionRepository;

    public boolean collectionCourse(Collection collection) {
//        Collection newCollection = collectionRepository.getCollectionByUserIdAndCourseId(collection.getUserId(),
//                collection.getCourseId());
//        if (newCollection != null) {
//            collection.setId(newCollection.getId());
//        }
        return collectionRepository.collectionCourse(collection);
    }

    public Collection getCollectionByUserIdAndCourseId(Long userId, Long courseId) {
        return collectionRepository.getCollectionByUserIdAndCourseId(userId, courseId);
    }
}
