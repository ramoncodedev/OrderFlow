package com.ordemflow.ordemFlow.bussiness.mapper;

import com.ordemflow.ordemFlow.bussiness.DTOs.request.UserRequest;
import com.ordemflow.ordemFlow.bussiness.DTOs.response.UserResponse;
import com.ordemflow.ordemFlow.infrastructure.Entity.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public static User toConvertRequest(UserRequest userRequest){
        return User.builder()
                .name(userRequest.name())
                .email(userRequest.email())
                .password(userRequest.password())
                .typedocument(userRequest.typedocument())
                .adress(userRequest.address())
                .document(userRequest.document())
                .build();
    }

    public static UserResponse toConvertResponse(User user){
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .password(user.getPassword())
                .email(user.getEmail())
                .typedocument(user.getTypedocument())
                .document(user.getDocument())
                .address(user.getAdress())
                .build();
    }
}
