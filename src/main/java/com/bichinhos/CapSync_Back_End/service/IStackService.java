package com.bichinhos.CapSync_Back_End.service;

import com.bichinhos.CapSync_Back_End.dto.request.StackRequest;
import com.bichinhos.CapSync_Back_End.dto.response.StackResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStackService {

    StackResponse createStack(StackRequest stackRequest);
    Page<StackResponse> getAllStacks(Pageable pageable);
    StackResponse getStackById(Long id);
    StackResponse updateStackById(Long id, StackRequest stackRequest);
    void deleteStackById(Long id);

}
