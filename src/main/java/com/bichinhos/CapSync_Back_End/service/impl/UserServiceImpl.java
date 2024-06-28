package com.bichinhos.CapSync_Back_End.service.impl;

import com.bichinhos.CapSync_Back_End.dto.mapper.UserAdminMapper;
import com.bichinhos.CapSync_Back_End.dto.mapper.UserProfileMapper;
import com.bichinhos.CapSync_Back_End.dto.mapper.UserSignUpMapper;
import com.bichinhos.CapSync_Back_End.dto.request.UserAdminEditRequest;
import com.bichinhos.CapSync_Back_End.dto.request.UserProfileRequest;
import com.bichinhos.CapSync_Back_End.dto.request.UserSignUpRequest;
import com.bichinhos.CapSync_Back_End.dto.response.UserAdminResponse;
import com.bichinhos.CapSync_Back_End.dto.response.UserProfileResponse;
import com.bichinhos.CapSync_Back_End.entity.UserEntity;
import com.bichinhos.CapSync_Back_End.exception.EntityAlreadyExists;
import com.bichinhos.CapSync_Back_End.exception.EntityNotFoundException;
import com.bichinhos.CapSync_Back_End.repository.IUserRepository;
import com.bichinhos.CapSync_Back_End.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements IUserService {

    private final IUserRepository iUserRepository;

    @Override
    public HttpStatus createUser(UserSignUpRequest userRequest){
        Optional<UserEntity> userEncouteredByDiscord = this.iUserRepository.findByDiscord(userRequest.discord());
        if (userEncouteredByDiscord.isPresent()){
            throw new EntityAlreadyExists("Usuario ja existe");
        }
        UserEntity userEntity = UserSignUpMapper.transformRequestToEntity(userRequest);
        userEntity.setPassword(new BCryptPasswordEncoder().encode(userEntity.getPassword()));
        this.iUserRepository.save(userEntity);
        return HttpStatus.CREATED;
    }


    @Override
    public UserAdminResponse updateVolunteerProfileByAdmin(UUID id, UserAdminEditRequest userAdminEditRequest) {
        Optional<UserEntity> userToUpdate = this.iUserRepository.findById(id);
        UserEntity existentUserEntity = userToUpdate.orElseThrow(() ->
                new EntityNotFoundException("User do ID " + id + " não encontrado."));
        UserEntity userEntityTransformed = UserAdminMapper.transformRequestToEntity(userAdminEditRequest);
        existentUserEntity.setStatus(userEntityTransformed.getStatus());
        existentUserEntity.setRole(userEntityTransformed.getRole());
        UserEntity userVolunteerEditedByAdmin = this.iUserRepository.save(existentUserEntity);
        return UserAdminMapper.transformEntityToResponse(userVolunteerEditedByAdmin);
    }

    @Override
    public Page<UserAdminResponse> getAllUsersByAdmin(Pageable pageable){
        Page<UserEntity> entities = this.iUserRepository.findAll(pageable);
        return entities.map(UserAdminMapper::transformEntityToResponse);
    }

    @Override
    public UserProfileResponse getUserById(UUID id) {
        UserEntity userEntityFounded = this.iUserRepository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("User com" + id + "não encontrado"));
        return UserProfileMapper.transformEntityToResponse(userEntityFounded);
    }
    @Override
    public UserProfileResponse updateEntityById(UUID id, UserProfileRequest userEditProfileRequest) {
        Optional<UserEntity> userToUpdate = this.iUserRepository.findById(id);
        UserEntity existentUserEntity = userToUpdate.orElseThrow(() ->
                new EntityNotFoundException("User do ID " + id + " não encontrado."));
        if (userEditProfileRequest.name() != null){
            existentUserEntity.setName(userEditProfileRequest.name());
        }
        if (userEditProfileRequest.surname() != null){
            existentUserEntity.setSurname(userEditProfileRequest.surname());
        }
        if (userEditProfileRequest.linkedin() != null){
            existentUserEntity.setLinkedin(userEditProfileRequest.linkedin());
        }
        if (userEditProfileRequest.discord() != null){
            existentUserEntity.setDiscord(userEditProfileRequest.discord());
        }
        if (userEditProfileRequest.cellphone() != null) {
            existentUserEntity.setCellphone(userEditProfileRequest.cellphone());
        }
        if (userEditProfileRequest.userPhoto() != null){
            existentUserEntity.setUserPhoto(userEditProfileRequest.userPhoto());
        }
        UserEntity userEntityUpdated = this.iUserRepository.save(existentUserEntity);
        return UserProfileMapper.transformEntityToResponse(userEntityUpdated);
    }

    @Override
    public void deleteEntityById(UUID id) {
        this.iUserRepository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("User do ID " + id + " não encontrado."));
        this.iUserRepository.deleteById(id);
    }

}
