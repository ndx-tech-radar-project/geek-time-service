package com.example.demo.domain.repository.Collection;

import com.example.demo.domain.modle.Collection.Collection;
import com.example.demo.domain.modle.Course.Course;
import com.example.demo.domain.modle.Course.CourseCollectionRequest;

import java.util.List;

public interface CollectionRepository {

    boolean collectionCourse(Collection courseCollectionRequest);

    Collection getCollectionByUserIdAndCourseId(Long userId, Long courseId);

    List<Course> findCollectionCoursesByUserId(Long valueOf);
}
