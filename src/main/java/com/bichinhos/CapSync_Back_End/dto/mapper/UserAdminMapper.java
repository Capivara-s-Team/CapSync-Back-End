package com.bichinhos.CapSync_Back_End.dto.mapper;

import com.bichinhos.CapSync_Back_End.dto.request.UserAdminEditRequest;
import com.bichinhos.CapSync_Back_End.dto.response.UserAdminResponse;
import com.bichinhos.CapSync_Back_End.entity.UserEntity;

public class UserAdminMapper {

        public static UserAdminResponse transformEntityToResponse(UserEntity userEntity){
        return UserAdminResponse.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .surname(userEntity.getSurname())
                .cellphone(userEntity.getCellphone())
                .email(userEntity.getEmail())
                .squad(userEntity.getSquad())
                .role(userEntity.getRole())
                .linkedin(userEntity.getLinkedin())
                .discord(userEntity.getDiscord())
                .userPhoto(userEntity.getUserPhoto())
                .autoRacialDeclaration(userEntity.getAutoRacialDeclaration())
                .gender(userEntity.getGender())
                .seniority(userEntity.getSeniority())
                .hasDisability(userEntity.getHasDisability())
                .disability(userEntity.getDisability())
                .roleDesired(userEntity.getRoleDesired())
                .meaningOfVolunteerWork(userEntity.getMeaningOfVolunteerWork())
                .firstOptionSquad(userEntity.getFirstOptionSquad())
                .secondOptionSquad(userEntity.getSecondOptionSquad())
                .reasonToBeVolunteer(userEntity.getReasonToBeVolunteer())
                .status(userEntity.getStatus())
                .build();
    }

        public static UserEntity transformRequestToEntity(UserAdminEditRequest userAdminEditRequest){
        return UserEntity.builder()
                .status(userAdminEditRequest.status())
                .role(userAdminEditRequest.role())
                .build();
    }
}
