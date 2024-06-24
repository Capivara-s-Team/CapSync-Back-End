package com.bichinhos.CapSync_Back_End.service.impl;

import com.bichinhos.CapSync_Back_End.entity.UserEntity;
import com.bichinhos.CapSync_Back_End.repository.IUserRepository;
import com.bichinhos.CapSync_Back_End.service.IUserService;

import java.util.UUID;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserRepository iUserRepository;

    @Override
    public UserEntity createUser(UserEntity userEntity) {
        return this.iUserRepository.save(userEntity);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return this.iUserRepository.findAll();
    }

    @Override
    public Optional<UserEntity> getUserById(UUID id) {
        return this.iUserRepository.findById(id);
    }

    @Override
    public UserEntity updateEntityById(UUID id, UserEntity userEntity) {
        Optional<UserEntity> userToUpdate = this.iUserRepository.findById(id);
        UserEntity existentUserEntity = userToUpdate.orElseThrow(() ->
                new EntityNotFoundException("User do ID " + id + " não encontrado."));

        if (userEntity.getName() != null){
            existentUserEntity.setName(userEntity.getName());
        }
        if (userEntity.getUserPhoto() != null){
            existentUserEntity.setUserPhoto(userEntity.getUserPhoto());
        }
        if (userEntity.getSurname() != null){
            existentUserEntity.setSurname(userEntity.getSurname());
        }
        if (userEntity.getLinkedin() != null){
            existentUserEntity.setLinkedin(userEntity.getLinkedin());
        }
        if (userEntity.getDiscord() != null){
            existentUserEntity.setDiscord(userEntity.getDiscord());
        }
        if (userEntity.getCellphone() != null){
            existentUserEntity.setCellphone(userEntity.getCellphone());
        }

        return this.iUserRepository.save(existentUserEntity);
    }

    @Override
    public void deleteEntityById(UUID id) {
        this.iUserRepository.deleteById(id);
    }

}
