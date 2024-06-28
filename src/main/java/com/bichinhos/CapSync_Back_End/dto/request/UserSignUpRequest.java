package com.bichinhos.CapSync_Back_End.dto.request;

import com.bichinhos.CapSync_Back_End.enumFields.Gender;
import com.bichinhos.CapSync_Back_End.enumFields.Role;
import com.bichinhos.CapSync_Back_End.enumFields.Seniority;
import com.bichinhos.CapSync_Back_End.utils.Regex;
import jakarta.validation.constraints.*;


public record UserSignUpRequest(

    @Size(min = 2, max = 60, message = "o nome não pode ter menos que 5 caracteres ou mais que 60")
    @NotBlank
    String name,
    @Size(min =  2, max = 60, message = "o sobrenome não pode ter menos que 5 caracteres ou mais que 60")
    @NotBlank
    String surname,
    @Email
    @NotBlank(message = "O email tem que ser valido")
    String email,
    @NotBlank
    @Pattern(regexp = Regex.PASSWORD,
            message = "A senha deve ter pelo menos 8 caracteres, incluindo uma letra minúscula, um dígito e um caractere especial"
    )
    String password,
    @NotBlank
    @Pattern(regexp = Regex.CELLPHONE_REGEX, message = "O numero deve ter um padrão de +55 DDD XXXXX XXXX")
    String cellphone,
    @NotBlank
    String squad,
    @NotBlank
    @Pattern(regexp = Regex.LINKEDIN, message = "O padrão de perfil do linkedin deve ser, 'www.linkedin.com/in/gustavo-brito2000'")
    String linkedin,
    @NotBlank
    @Pattern(regexp = Regex.DISCORD, message = "O padrão de nome de usuario do Discord deve ser como 'Nome do usuario#1234'")
    String discord,
    @NotBlank
    String autoRacialDeclaration,
    //todo: Desacoplar os atributos abaixo para uma nova entidade no banco
    @Size(min = 5, max = 60, message = "O campo de deficiencia deve ter pelo menos uma deficiencia.")
    String disability,
    @NotNull
    Boolean hasDisability,
    @NotBlank
    @Size(min = 5, max = 60, message = "O campo deve ter mais que um caractere")
    String firstOptionSquad,
    @NotBlank
    @Size(min = 5, max = 60, message = "O campo deve ter mais que um caractere")
    String secondOptionSquad,
    @NotBlank
    @Size(min = 5, max = 60, message = "O campo deve ter mais que um caractere")
    String reasonToBeVolunteer,
    @NotBlank
    @Size(min = 5, max = 60, message = "O campo deve ter mais que um caractere")
    String meaningOfVolunteerWork,
    //todo: tratar esses ENUMS abaixo para um requisição errada
    Role roleDesired,
    Gender gender,
    Seniority seniority

){}
