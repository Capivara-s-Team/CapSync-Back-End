package com.bichinhos.CapSync_Back_End.service;

import com.bichinhos.CapSync_Back_End.dto.request.UserAdminEditRequest;
import com.bichinhos.CapSync_Back_End.dto.request.UserProfileRequest;
import com.bichinhos.CapSync_Back_End.dto.request.UserSignUpRequest;
import com.bichinhos.CapSync_Back_End.dto.response.UserAdminResponse;
import com.bichinhos.CapSync_Back_End.dto.response.UserProfileResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;

import java.util.UUID;




public interface IUserService {
    HttpStatus createUser(UserSignUpRequest userSignUpRequest);
    Page<UserAdminResponse> getAllUsersByAdmin(Pageable pageable);
    UserProfileResponse getUserById(UUID id);
    UserProfileResponse updateEntityById(UUID id, UserProfileRequest userProfileRequest);
    UserAdminResponse updateVolunteerProfileByAdmin(UUID id,UserAdminEditRequest userAdminEditRequest);
    void deleteEntityById(UUID id);
}
