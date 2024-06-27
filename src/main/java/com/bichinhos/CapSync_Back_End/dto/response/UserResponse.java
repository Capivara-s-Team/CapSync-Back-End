package com.bichinhos.CapSync_Back_End.dto.response;

import com.bichinhos.CapSync_Back_End.enumFields.Gender;
import com.bichinhos.CapSync_Back_End.enumFields.Role;
import com.bichinhos.CapSync_Back_End.enumFields.Seniority;
import lombok.Builder;

import java.util.UUID;

@Builder

public record UserResponse (
     UUID id,
     String name,

     String surname,

     String cellphone,

     String email,

     String squad,

     String linkedin,

     String discord,

     String userPhoto,

     String autoRacialDeclaration,

     Gender gender,

     Seniority seniority,

     Role role
){}
