package com.bichinhos.CapSync_Back_End.dto.mapper;

import com.bichinhos.CapSync_Back_End.dto.request.SquadRequest;
import com.bichinhos.CapSync_Back_End.dto.response.SquadResponse;
import com.bichinhos.CapSync_Back_End.entity.SquadEntity;

public class SquadMapper {

    public static SquadResponse transformEntityToResponse(SquadEntity squadEntity){
        return new SquadResponse(squadEntity.getId(), squadEntity.getName());
    }

    public static SquadEntity transformRequestToEntity(SquadRequest squadRequest){
        return SquadEntity.builder()
                .name(squadRequest.name())
                .build();
    }

}
