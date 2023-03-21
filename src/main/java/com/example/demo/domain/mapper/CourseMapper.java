package com.example.demo.domain.mapper;

import com.example.demo.domain.Entity.CourseEntity;
import com.example.demo.domain.Entity.UserEntity;
import com.example.demo.domain.modle.Course.Course;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CourseMapper {

    CourseMapper MAPPER = Mappers.getMapper(CourseMapper.class);

    List<Course> toModel(List<CourseEntity> entity);
}
