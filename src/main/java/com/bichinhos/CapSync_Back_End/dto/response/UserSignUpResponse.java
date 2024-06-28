package com.bichinhos.CapSync_Back_End.dto.response;

import com.bichinhos.CapSync_Back_End.enumFields.Gender;
import com.bichinhos.CapSync_Back_End.enumFields.Role;
import com.bichinhos.CapSync_Back_End.enumFields.Seniority;
import lombok.Builder;

@Builder
public record UserSignUpResponse (

    String name,

    String surname,

    String email,

    String password,

    String cellphone,

    String squad,

    String linkedin,

    String discord,

    String autoRacialDeclaration,
    //todo: Desacoplar os atributos abaixo para uma nova entidade no banco
    String disability,

    Boolean hasDisability,
    String firstOptionSquad,

    String secondOptionSquad,

    String reasonToBeVolunteer,

    String meaningOfVolunteerWork,

    Role roleDesired,

    Gender gender,

    Seniority seniority
){}
