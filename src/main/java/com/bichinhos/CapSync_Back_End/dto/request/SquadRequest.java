package com.bichinhos.CapSync_Back_End.dto.request;

import jakarta.validation.constraints.NotBlank;

public record SquadRequest (
        @NotBlank
        String name
) {
}
