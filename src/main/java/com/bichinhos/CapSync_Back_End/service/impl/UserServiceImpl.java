package com.bichinhos.CapSync_Back_End.service.impl;

import com.bichinhos.CapSync_Back_End.entity.UserEntity;
import com.bichinhos.CapSync_Back_End.repository.ICreateUserRepository;
import com.bichinhos.CapSync_Back_End.service.ICreateUserService;
import org.hibernate.validator.constraints.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements ICreateUserService {

    @Autowired
    ICreateUserRepository iCreateUserRepository;

    @Override
    public UserEntity createUser(UserEntity userEntity) {
        return this.iCreateUserRepository.save(userEntity);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return List.of();
    }

    @Override
    public UserEntity getUserById(UUID id) {
        return null;
    }

    @Override
    public UserEntity updateEntity(UUID id, UserEntity userEntity) {
        return null;
    }

    @Override
    public void deleteEntityById(UUID id) {

    }
}
