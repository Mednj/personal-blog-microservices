package com.naja.userservice.mapper;

import com.naja.userservice.dto.ProfileDto;
import com.naja.userservice.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    ProfileDto userToProfileDto(User user);
}
