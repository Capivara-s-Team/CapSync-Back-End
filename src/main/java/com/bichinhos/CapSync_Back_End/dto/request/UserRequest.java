package com.bichinhos.CapSync_Back_End.dto.request;

import com.bichinhos.CapSync_Back_End.enumFields.*;
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
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",
            message = "A senha deve ter pelo menos 8 caracteres, incluindo uma letra minúscula, um dígito e um caractere especial"
    )
    private String password;
    @NotBlank
    private String cellphone;
    @NotBlank
    private String squad;
    @NotBlank
    private String role;
    @NotBlank
    private String linkedin;
    @NotBlank
    private String discord;

    private String userPhoto;

    private String autoRacialDeclaration;

    private Status status;

    private Gender gender;

    private Seniority seniority;
}
