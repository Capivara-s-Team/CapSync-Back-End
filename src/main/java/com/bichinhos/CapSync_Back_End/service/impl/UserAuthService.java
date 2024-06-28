package com.bichinhos.CapSync_Back_End.service.impl;

import com.bichinhos.CapSync_Back_End.dto.mapper.UserAuthMapper;
import com.bichinhos.CapSync_Back_End.dto.response.UserAuthResponse;
import com.bichinhos.CapSync_Back_End.entity.UserEntity;
import com.bichinhos.CapSync_Back_End.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserAuthService implements UserDetailsService {

    private final IUserRepository iUserRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return iUserRepository.findByEmail(email);
    }

    public UserAuthResponse getUserUUIDByEmail(String email){
        UserEntity userUUID = iUserRepository.findByEmailToGetEntity(email);
        return UserAuthMapper.transformEntityToResponse(userUUID);
    }

}
