package com.bichinhos.CapSync_Back_End.dto.mapper;

import com.bichinhos.CapSync_Back_End.dto.request.UserSignUpRequest;
import com.bichinhos.CapSync_Back_End.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserSignUpMapper {
    public static UserEntity transformRequestToEntity(UserSignUpRequest userRequest){
        return UserEntity.builder()
                .name(userRequest.name())
                .surname(userRequest.surname())
                .email(userRequest.email())
                .password(userRequest.password())
                .cellphone(userRequest.cellphone())
                .squad(userRequest.squad())
                .linkedin(userRequest.linkedin())
                .discord(userRequest.discord())
                .autoRacialDeclaration(userRequest.autoRacialDeclaration())
                .gender(userRequest.gender())
                .seniority(userRequest.seniority())
                .hasDisability(userRequest.hasDisability())
                .disability(userRequest.disability())
                .roleDesired(userRequest.roleDesired())
                .meaningOfVolunteerWork(userRequest.meaningOfVolunteerWork())
                .firstOptionSquad(userRequest.firstOptionSquad())
                .secondOptionSquad(userRequest.secondOptionSquad())
                .reasonToBeVolunteer(userRequest.reasonToBeVolunteer())
                .build();
    }


}
