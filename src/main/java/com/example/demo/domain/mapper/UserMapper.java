package com.example.demo.domain.mapper;

import com.example.demo.domain.modle.User;
import com.example.demo.domain.repository.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    User toModel(UserEntity entity);

    List<User> toModel(List<UserEntity> entity);
}
