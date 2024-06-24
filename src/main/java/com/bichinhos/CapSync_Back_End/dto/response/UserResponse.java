package com.bichinhos.CapSync_Back_End.dto.response;

import com.bichinhos.CapSync_Back_End.enumFields.Gender;
import com.bichinhos.CapSync_Back_End.enumFields.Seniority;
import com.bichinhos.CapSync_Back_End.enumFields.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {

    private String name;

    private String surname;
    @JsonIgnore
    private String email;
    @JsonIgnore
    private String password;

    private String cellphone;

    private String squad;

    private String role;

    private String linkedin;

    private String discord;

    private String userPhoto;

    private String autoRacialDeclaration;

    private Status status;

    private Gender gender;

    private Seniority seniority;
}
