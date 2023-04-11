package com.example.demo.domain.mapper;

import com.example.demo.domain.Entity.CollectionEntity;
import com.example.demo.domain.modle.Collection.Collection;
import com.example.demo.domain.modle.Course.CourseCollectionRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CollectionMapper {

    CollectionMapper MAPPER = Mappers.getMapper(CollectionMapper.class);

    List<Collection> toModel(List<CollectionEntity> entity);

    CollectionEntity toEntity(Collection model);

    Collection toModel(CollectionEntity entity);

}
