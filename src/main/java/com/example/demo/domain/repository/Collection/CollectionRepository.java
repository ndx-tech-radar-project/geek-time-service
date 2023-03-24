package com.example.demo.domain.repository.Collection;

import com.example.demo.domain.modle.Collection.Collection;
import com.example.demo.domain.modle.Course.CourseCollectionRequest;

public interface CollectionRepository {

    boolean collectionCourse(Collection courseCollectionRequest);
}
