package com.minidrive.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.minidrive.dto.request.UserCreationRequest;
import com.minidrive.dto.request.UserUpdateRequest;
import com.minidrive.dto.response.UserResponse;
import com.minidrive.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest dto);
    UserResponse toUserResponse(User user);
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
