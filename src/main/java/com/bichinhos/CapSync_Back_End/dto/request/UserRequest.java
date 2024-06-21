package com.bichinhos.CapSync_Back_End.dto.request;

import com.bichinhos.CapSync_Back_End.enumFields.*;
import com.bichinhos.CapSync_Back_End.utils.Regex;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserRequest {

    @Size(min = 5, max = 60, message = "o nome não pode ter menos que 5 caracteres ou mais que 60")
    @NotBlank
    private String name;
    @Email
    @NotBlank(message = "O email tem que ser valido")
    private String email;
    @NotBlank
    @Pattern(regexp = Regex.PASSWORD,
            message = "A senha deve ter pelo menos 8 caracteres, incluindo uma letra minúscula, um dígito e um caractere especial"
    )
    private String password;
    @NotBlank
    @Pattern(regexp = Regex.CELLPHONE)
    private String cellphone;
    @NotBlank
    private String squad;
    @NotBlank
    private String role;
    @NotBlank
    @Pattern(regexp = Regex.LINK)
    private String linkedin;
    @NotBlank
    @Pattern(regexp = Regex.DISCORD)
    private String discord;
    @Pattern(regexp = Regex.ONLY_LETTERS)
    private String userPhoto;

    private String autoRacialDeclaration;

    private Status status;

    private Gender gender;

    private Seniority seniority;
}
