package com.bichinhos.CapSync_Back_End.controller;

import com.bichinhos.CapSync_Back_End.dto.request.UserAuthRequest;
import com.bichinhos.CapSync_Back_End.dto.response.UserAuthResponse;
import com.bichinhos.CapSync_Back_End.entity.UserEntity;
import com.bichinhos.CapSync_Back_End.infra.security.TokenGenerator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserAuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenGenerator tokenGenerator;

    @PostMapping("/login")
    public ResponseEntity<?> userLogin(@RequestBody @Valid UserAuthRequest userAuthRequest){
        var usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userAuthRequest.email(), userAuthRequest.password());
        var auth = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        var token = tokenGenerator.generateToken((UserEntity) auth.getPrincipal());

        return ResponseEntity.ok(new UserAuthResponse(token));
    }
}
