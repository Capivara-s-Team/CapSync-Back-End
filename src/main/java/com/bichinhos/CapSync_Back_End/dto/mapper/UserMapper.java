package com.bichinhos.CapSync_Back_End.dto.mapper;

import com.bichinhos.CapSync_Back_End.dto.request.UserRequest;
import com.bichinhos.CapSync_Back_End.dto.response.UserResponse;
import com.bichinhos.CapSync_Back_End.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public static UserEntity transformRequestToEntity(UserRequest userRequest){
        return UserEntity.builder()
                .name(userRequest.name())
                .surname(userRequest.surname())
                .email(userRequest.email())
                .password(userRequest.password())
                .cellphone(userRequest.cellphone())
                .squad(userRequest.squad())
                .role(userRequest.role())
                .linkedin(userRequest.linkedin())
                .discord(userRequest.discord())
                .userPhoto(userRequest.userPhoto())
                .autoRacialDeclaration(userRequest.autoRacialDeclaration())
                .gender(userRequest.gender())
                .seniority(userRequest.seniority())
                .build();
    }

    public static UserResponse transformEntityToResponse(UserEntity userEntity){
        return UserResponse.builder()
                .name(userEntity.getName())
                .surname(userEntity.getSurname())
                .cellphone(userEntity.getCellphone())
                .squad(userEntity.getSquad())
                .role(userEntity.getRole())
                .linkedin(userEntity.getLinkedin())
                .discord(userEntity.getDiscord())
                .userPhoto(userEntity.getUserPhoto())
                .autoRacialDeclaration(userEntity.getAutoRacialDeclaration())
                .gender(userEntity.getGender())
                .seniority(userEntity.getSeniority())
                .build();
    }
}
