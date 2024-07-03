package com.bichinhos.CapSync_Back_End.dto.response;

import lombok.Builder;

import java.util.UUID;

@Builder
public record UserAuthResponse (UUID id, String token){}
