package com.bichinhos.CapSync_Back_End.dto.response;

import com.bichinhos.CapSync_Back_End.enumFields.Gender;
import com.bichinhos.CapSync_Back_End.enumFields.Seniority;
import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class UserResponse {

    private String name;

    private String surname;

    private String cellphone;

    private String squad;

    private String role;

    private String linkedin;

    private String discord;

    private String userPhoto;

    private String autoRacialDeclaration;

    private Gender gender;

    private Seniority seniority;
}
