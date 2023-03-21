package com.example.demo.domain.repository.Course;

import com.example.demo.domain.Entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepositoryJpa extends JpaRepository<CourseEntity, Long> {
}


