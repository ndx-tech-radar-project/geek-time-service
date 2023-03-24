package com.example.demo.domain.repository.Collection;

import com.example.demo.domain.Entity.CollectionEntity;
import com.example.demo.domain.mapper.CollectionMapper;
import com.example.demo.domain.mapper.CourseMapper;
import com.example.demo.domain.modle.Collection.Collection;
import com.example.demo.domain.modle.Course.Course;
import com.example.demo.domain.modle.Course.CourseCollectionRequest;
import com.example.demo.domain.repository.Course.CourseRepositoryJpa;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CollectionRepositoryImpl implements CollectionRepository {

    private final CollectionRepositoryJpa collectionRepositoryJpa;


    @Override
    public boolean collectionCourse(Collection courseCollectionRequest) {
        CollectionEntity collectionEntity = CollectionMapper.MAPPER.toEntity(courseCollectionRequest);
        return collectionRepositoryJpa.save(collectionEntity) != null;
    }

}
