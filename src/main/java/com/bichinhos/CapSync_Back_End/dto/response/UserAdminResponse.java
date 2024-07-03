package com.bichinhos.CapSync_Back_End.dto.response;

import com.bichinhos.CapSync_Back_End.enumFields.Gender;
import com.bichinhos.CapSync_Back_End.enumFields.Role;
import com.bichinhos.CapSync_Back_End.enumFields.Seniority;
import com.bichinhos.CapSync_Back_End.enumFields.Status;
import lombok.Builder;

import java.util.UUID;

@Builder
public record UserAdminResponse (
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

        String disability,

        Boolean hasDisability,

        String firstOptionSquad,

        String secondOptionSquad,

        String reasonToBeVolunteer,

        String meaningOfVolunteerWork,

        Status status,

        Role roleDesired,

        Gender gender,

        Seniority seniority,

        Role role
){}
