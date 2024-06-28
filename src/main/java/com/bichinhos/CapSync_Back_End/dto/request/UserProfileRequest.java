package com.bichinhos.CapSync_Back_End.dto.request;

import com.bichinhos.CapSync_Back_End.utils.Regex;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserProfileRequest(
        @Size(min = 5, max = 60,
                message = "o nome não pode ter menos que 5 caracteres ou mais que 60")
        String name,
        @Size(min =  5, max = 60,
                message = "o sobrenome não pode ter menos que 5 caracteres ou mais que 60")
        String surname,

        @Pattern(regexp = Regex.LINKEDIN,
                message = "O padrão de perfil do linkedin deve ser, 'www.linkedin.com/in/gustavo-brito2000'")
        String linkedin,

        @Pattern(regexp = Regex.DISCORD,
                message = "O padrão de nome de usuario do Discord deve ser como 'Nome do usuario#1234'")
        String discord,

        @Pattern(regexp = Regex.CELLPHONE_REGEX,
                message = "O numero deve ter um padrão de +55 DDD XXXXX XXXX")
        String cellphone,

        @Pattern(regexp = Regex.ASSETS_PATHS,
        message = "O caminho para a foto deve seguir o padrão de src/assets/'nome da pessoa', as extensões aceitas são, svg ou png ou jpeg, não aceitamos simbolos no nome das fotos")
        String userPhoto

        //todo: adicionar a stack para alteração
)
{}