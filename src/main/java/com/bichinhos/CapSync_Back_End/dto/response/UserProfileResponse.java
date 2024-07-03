package com.bichinhos.CapSync_Back_End.dto.response;

import lombok.Builder;

import java.util.UUID;

@Builder
public record UserProfileResponse(
     UUID id,
     String name,

     String surname,

     String cellphone,

     String linkedin,

     String discord,

     String userPhoto
){}
