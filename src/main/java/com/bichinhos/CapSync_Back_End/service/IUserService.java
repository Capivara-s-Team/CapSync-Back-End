package com.bichinhos.CapSync_Back_End.service;

import com.bichinhos.CapSync_Back_End.entity.UserEntity;
import java.util.UUID;

import java.util.List;
import java.util.Optional;


public interface IUserService {
    UserEntity createUser(UserEntity userEntity);
    List<UserEntity> getAllUsers();
    Optional<UserEntity> getUserById(UUID id);
    UserEntity updateEntityById(UUID id, UserEntity userEntity);
    void deleteEntityById(UUID id);
}
