package com.bichinhos.CapSync_Back_End.service;

import com.bichinhos.CapSync_Back_End.dto.request.UserRequest;
import com.bichinhos.CapSync_Back_End.dto.response.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;




public interface IUserService {
    UserResponse createUser(UserRequest userEntity);
    Page<UserResponse> getAllUsers(Pageable pageable);
    UserResponse getUserById(UUID id);
    UserResponse updateEntityById(UUID id, UserRequest userEntity);
    void deleteEntityById(UUID id);
}
