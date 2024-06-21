package com.bichinhos.CapSync_Back_End.service;

import com.bichinhos.CapSync_Back_End.entity.UserEntity;
import org.hibernate.validator.constraints.UUID;

import java.util.List;


public interface ICreateUserService {
    UserEntity createUser(UserEntity userEntity);
    List<UserEntity> getAllUsers();
    UserEntity getUserById(UUID id);
    UserEntity updateEntity(UUID id, UserEntity userEntity);
    void deleteEntityById(UUID id);
}
