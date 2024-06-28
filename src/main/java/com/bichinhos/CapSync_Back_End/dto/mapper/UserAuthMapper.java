package com.bichinhos.CapSync_Back_End.dto.mapper;

import com.bichinhos.CapSync_Back_End.dto.response.UserAuthResponse;
import com.bichinhos.CapSync_Back_End.entity.UserEntity;

public class UserAuthMapper {
    public static UserAuthResponse transformEntityToResponse(UserEntity userEntity){
        return UserAuthResponse.builder()
                .id(userEntity.getId())
                .build();
}
}
