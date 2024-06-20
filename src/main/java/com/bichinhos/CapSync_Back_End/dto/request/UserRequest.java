package com.bichinhos.CapSync_Back_End.dto.request;

import com.bichinhos.CapSync_Back_End.enumFields.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRequest {
    @Size(min = 5, max = 60)
    @NotBlank
    private String name;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String cellphone;
    @NotBlank
    private EnumSquad enumSquad;
    @NotBlank
    private EnumRole enumRole;
    @NotBlank
    private String linkedin;
    @NotBlank
    private String discord;

    private EnumSeniority enumSeniority;

    private String userPhoto;

    private String autoRacialDeclaration;

    private EnumGender enumGender;

    private EnumStatus enumStatus;
}
