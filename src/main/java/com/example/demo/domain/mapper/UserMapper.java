package com.example.demo.domain.mapper;

import com.example.demo.domain.modle.User.User;
import com.example.demo.domain.Entity.UserEntity;
import com.example.demo.domain.modle.User.UserLoginRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    User toModel(UserEntity entity);

    List<User> toModel(List<UserEntity> entity);

    UserEntity toEntity(User model);

    User toModel(UserLoginRequest model);
}

