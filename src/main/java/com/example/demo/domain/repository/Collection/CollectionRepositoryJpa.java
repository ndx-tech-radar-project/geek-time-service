package com.example.demo.domain.repository.Collection;

import com.example.demo.domain.Entity.CollectionEntity;
import com.example.demo.domain.Entity.CourseEntity;
import com.example.demo.domain.modle.Course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectionRepositoryJpa extends JpaRepository<CollectionEntity, Long> {


    CollectionEntity getCollectionByUserIdAndCourseId(Long userId, Long courseId);

    @Query(value = "select c from CourseEntity c where c.id  in (select c.courseId from CollectionEntity c where c" +
            ".userId = ?1 and c.isCollection = 1)")
    List<CourseEntity> findCollectionCoursesByUserId(Long valueOf);

}
