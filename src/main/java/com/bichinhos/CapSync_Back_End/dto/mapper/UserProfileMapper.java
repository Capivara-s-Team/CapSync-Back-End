package com.bichinhos.CapSync_Back_End.dto.mapper;

import com.bichinhos.CapSync_Back_End.dto.response.UserProfileResponse;
import com.bichinhos.CapSync_Back_End.entity.UserEntity;

public class UserProfileMapper {

    public static UserProfileResponse transformEntityToResponse(UserEntity userEntity){
        return UserProfileResponse.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .surname(userEntity.getSurname())
                .cellphone(userEntity.getCellphone())
                .linkedin(userEntity.getLinkedin())
                .discord(userEntity.getDiscord())
                .userPhoto(userEntity.getUserPhoto())
                .build();
    }
}
