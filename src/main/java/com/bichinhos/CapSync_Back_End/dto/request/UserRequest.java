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
    @Size(min =  5, max = 60, message = "o sobrenome não pode ter menos que 5 caracteres ou mais que 60")
    @NotBlank
    private String surname;
    @Email
    @NotBlank(message = "O email tem que ser valido")
    private String email;
    @NotBlank
    @Pattern(regexp = Regex.PASSWORD,
            message = "A senha deve ter pelo menos 8 caracteres, incluindo uma letra minúscula, um dígito e um caractere especial"
    )
    private String password;
    @NotBlank
    @Pattern(regexp = Regex.CELLPHONE_REGEX, message = "O numero deve ter um padrão de +55 DDD XXXXX XXXX")
    private String cellphone;
    @NotBlank
    private String squad;
    @NotBlank
    private String role;
    @NotBlank
    @Pattern(regexp = Regex.LINKEDIN, message = "O padrão de perfil do linkedin deve ser, 'www.linkedin.com/in/gustavo-brito2000'")
    private String linkedin;
    @NotBlank
    @Pattern(regexp = Regex.DISCORD, message = "O padrão de nome de usuario do Discord deve ser como 'Nome do usuario#1234'")
    private String discord;
    @Pattern(regexp = Regex.ASSETS_PATHS,
            message = "O caminho para a foto deve seguir o padrão de src/assets/'nome da pessoa', as extensões aceitas são, svg ou png ou jpeg, não aceitamos simbolos no nome das fotos")
    private String userPhoto;

    private String autoRacialDeclaration;

    private Status status;

    private Gender gender;

    private Seniority seniority;
}
