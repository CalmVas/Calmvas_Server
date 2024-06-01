package org.momo.Member.Converter;

import java.time.LocalDateTime;

import org.momo.Member.Dto.UserRequest;
import org.momo.Member.Dto.UserResponse;
import org.momo.Member.Entity.User;

public class UserConverter {
    public static UserResponse.UserCreateResponse toUserCreateResponse(User user){
        return UserResponse.UserCreateResponse.builder()
                .id(user.getUserId())
                .name(user.getUsername())
                .build();
    }

    public static UserResponse.UserLoginResponse toUserLoginResponse(User user){
        return UserResponse.UserLoginResponse.builder()
                .id(user.getUserId())
                .name(user.getUsername())
                .build();
    }

    public static User toUserEntity(UserRequest.UserCreateRequest userCreateRequest){
        return User.builder()
                .username(userCreateRequest.getName())
                .password(userCreateRequest.getPassword())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
