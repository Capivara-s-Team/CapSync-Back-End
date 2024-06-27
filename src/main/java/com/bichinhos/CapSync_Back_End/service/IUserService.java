package com.bichinhos.CapSync_Back_End.service;

import com.bichinhos.CapSync_Back_End.dto.request.UserRequest;
import com.bichinhos.CapSync_Back_End.dto.response.UserResponse;
import com.bichinhos.CapSync_Back_End.entity.UserEntity;
import java.util.UUID;

import java.util.List;
import java.util.Optional;


public interface IUserService {
    UserResponse createUser(UserRequest userEntity);
    List<UserEntity> getAllUsers();
    Optional<UserEntity> getUserById(UUID id);
    UserResponse updateEntityById(UUID id, UserRequest userEntity);
    void deleteEntityById(UUID id);
}
