package com.bichinhos.CapSync_Back_End.service.impl;

import com.bichinhos.CapSync_Back_End.dto.mapper.UserMapper;
import com.bichinhos.CapSync_Back_End.dto.request.UserRequest;
import com.bichinhos.CapSync_Back_End.dto.response.UserResponse;
import com.bichinhos.CapSync_Back_End.entity.UserEntity;
import com.bichinhos.CapSync_Back_End.repository.IUserRepository;
import com.bichinhos.CapSync_Back_End.service.IUserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements IUserService {

    private final IUserRepository iUserRepository;

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        UserEntity userEntity = UserMapper.transformRequestToEntity(userRequest);
        userEntity.setPassword(new BCryptPasswordEncoder().encode(userEntity.getPassword()));
        UserEntity userCreated = this.iUserRepository.save(userEntity);
        return UserMapper.transformEntityToResponse(userCreated);
    }

    @Override
    public List<UserEntity> getAllUsers(){
        return this.iUserRepository.findAll();
    }

    @Override
    public Optional<UserEntity> getUserById(UUID id) {
        return this.iUserRepository.findById(id);
    }

    @Override
    public UserResponse updateEntityById(UUID id, UserRequest userRequest) {
        Optional<UserEntity> userToUpdate = this.iUserRepository.findById(id);
        UserEntity existentUserEntity = userToUpdate.orElseThrow(() ->
                new EntityNotFoundException("User do ID " + id + " não encontrado."));
        if (userRequest.name() != null){
            existentUserEntity.setName(userRequest.name());
        }
        if (userRequest.userPhoto() != null){
            existentUserEntity.setUserPhoto(userRequest.userPhoto());
        }
        if (userRequest.surname() != null){
            existentUserEntity.setSurname(userRequest.surname());
        }
        if (userRequest.linkedin() != null){
            existentUserEntity.setLinkedin(userRequest.linkedin());
        }
        if (userRequest.discord() != null){
            existentUserEntity.setDiscord(userRequest.discord());
        }
        if (userRequest.cellphone() != null) {
            existentUserEntity.setCellphone(userRequest.cellphone());
        }
        UserEntity userEntityUpdated = this.iUserRepository.save(existentUserEntity);
        return UserMapper.transformEntityToResponse(userEntityUpdated);
    }

    @Override
    public void deleteEntityById(UUID id) {
        this.iUserRepository.deleteById(id);
    }

}
