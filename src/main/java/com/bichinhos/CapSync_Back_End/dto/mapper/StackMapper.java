package com.bichinhos.CapSync_Back_End.dto.mapper;

import com.bichinhos.CapSync_Back_End.dto.request.StackRequest;
import com.bichinhos.CapSync_Back_End.dto.response.StackResponse;
import com.bichinhos.CapSync_Back_End.entity.StackEntity;

public class StackMapper {
    public static StackEntity transformRequestToEntity(StackRequest stackRequest){
        return StackEntity.builder()
                .name(stackRequest.name())
                .build();
    }

    public static StackResponse transformEntityToResponse(StackEntity stackEntity){
        return new StackResponse(stackEntity.getId(), stackEntity.getName());
    }

}
