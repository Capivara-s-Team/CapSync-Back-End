package com.bichinhos.CapSync_Back_End.dto.mapper;

import com.bichinhos.CapSync_Back_End.dto.request.UserRequest;
import com.bichinhos.CapSync_Back_End.dto.response.UserResponse;
import com.bichinhos.CapSync_Back_End.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserEntity transformRequestToEntity(UserRequest userRequest){
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userRequest.getName());

        userEntity.setEmail(userRequest.getEmail());

        userEntity.setPassword(userRequest.getPassword());

        userEntity.setCellphone(userRequest.getCellphone());

        userEntity.setSquad(userRequest.getSquad());

        userEntity.setRole(userRequest.getRole());

        userEntity.setLinkedin(userRequest.getLinkedin());

        userEntity.setDiscord(userRequest.getDiscord());

        userEntity.setUserPhoto(userRequest.getUserPhoto());

        userEntity.setAutoRacialDeclaration(userRequest.getAutoRacialDeclaration());

        userEntity.setGender(userRequest.getGender());

        userEntity.setSeniority(userRequest.getSeniority());

        userEntity.setStatus(userRequest.getStatus());

        return userEntity;
    }

    public UserResponse transformEntityToResponse(UserEntity userEntity){
        UserResponse userResponse = new UserResponse();
        userResponse.setName(userEntity.getName());

        userResponse.setEmail(userEntity.getEmail());

        userResponse.setPassword(userEntity.getPassword());

        userResponse.setCellphone(userEntity.getCellphone());

        userResponse.setSquad(userEntity.getSquad());

        userResponse.setRole(userEntity.getRole());

        userResponse.setLinkedin(userEntity.getLinkedin());

        userResponse.setDiscord(userEntity.getDiscord());

        userResponse.setUserPhoto(userEntity.getUserPhoto());

        userResponse.setAutoRacialDeclaration(userEntity.getAutoRacialDeclaration());

        userResponse.setGender(userEntity.getGender());

        userResponse.setSeniority(userEntity.getSeniority());

        userResponse.setStatus(userEntity.getStatus());

        return userResponse;
    }
}
