package com.example.demo.domain.repository.Collection;

import com.example.demo.domain.Entity.CollectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectionRepositoryJpa extends JpaRepository<CollectionEntity, Long> {


    CollectionEntity getCollectionByUserIdAndCourseId(Long userId, Long courseId);
}
