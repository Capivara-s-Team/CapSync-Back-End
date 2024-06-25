package com.bichinhos.CapSync_Back_End.service;

import com.bichinhos.CapSync_Back_End.dto.request.StackRequest;
import com.bichinhos.CapSync_Back_End.dto.response.StackResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStackService {

    StackResponse createStack(StackRequest stackRequest);
    Page<StackResponse> getAllUsers(Pageable pageable);
    StackResponse getUserById(Long id);
    StackResponse updateEntityById(Long id, StackRequest stackRequest);
    void deleteEntityById(Long id);

}
