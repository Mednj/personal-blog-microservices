package com.naja.blog.mapper;

import com.naja.blog.dto.ProfileDto;
import com.naja.blog.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    ProfileDto userToProfileDto(User user);
}
