package com.bichinhos.CapSync_Back_End.dto.response;

import com.bichinhos.CapSync_Back_End.enumFields.Gender;
import com.bichinhos.CapSync_Back_End.enumFields.Role;
import com.bichinhos.CapSync_Back_End.enumFields.Seniority;
import lombok.Builder;

@Builder

public record UserResponse (

     String name,

     String surname,

     String cellphone,

     String squad,

     String linkedin,

     String discord,

     String userPhoto,

     String autoRacialDeclaration,

     Gender gender,

     Seniority seniority,

     Role role
){}
