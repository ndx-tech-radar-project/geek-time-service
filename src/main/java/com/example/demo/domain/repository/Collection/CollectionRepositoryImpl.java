package com.example.demo.domain.repository.Collection;

import com.example.demo.domain.Entity.CollectionEntity;
import com.example.demo.domain.mapper.CollectionMapper;
import com.example.demo.domain.mapper.CourseMapper;
import com.example.demo.domain.modle.Collection.Collection;
import com.example.demo.domain.modle.Course.Course;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CollectionRepositoryImpl implements CollectionRepository {

    private final CollectionRepositoryJpa collectionRepositoryJpa;

    @Override
    public boolean collectionCourse(Collection courseCollectionRequest) {
        CollectionEntity collectionEntity =
                collectionRepositoryJpa.getCollectionByUserIdAndCourseId(courseCollectionRequest.getUserId(),
                        courseCollectionRequest.getCourseId());
        if (collectionEntity == null) {
            CollectionEntity collectionEntity1 = CollectionMapper.MAPPER.toEntity(courseCollectionRequest);
            return collectionRepositoryJpa.save(collectionEntity1) != null;
        }
        collectionEntity.setIsCollection(courseCollectionRequest.getIsCollection());
        return collectionRepositoryJpa.save(collectionEntity) != null;
    }

    @Override
    public Collection getCollectionByUserIdAndCourseId(Long userId, Long courseId) {
        CollectionEntity collectionEntity = collectionRepositoryJpa.getCollectionByUserIdAndCourseId(userId, courseId);
        return CollectionMapper.MAPPER.toModel(collectionEntity);
    }

    @Override
    public List<Course> findCollectionCoursesByUserId(Long valueOf) {
        List<Course> courseList = CourseMapper.MAPPER.toModel(collectionRepositoryJpa.findCollectionCoursesByUserId(valueOf));
        return courseList;
    }

}
