package com.bichinhos.CapSync_Back_End.controller;


import com.bichinhos.CapSync_Back_End.dto.request.UserAdminEditRequest;
import com.bichinhos.CapSync_Back_End.dto.request.UserProfileRequest;
import com.bichinhos.CapSync_Back_End.dto.request.UserSignUpRequest;
import com.bichinhos.CapSync_Back_End.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestBody @Valid UserSignUpRequest userRequest){
        this.userServiceImpl.createUser(userRequest);
        return ResponseEntity.created(URI.create("user/register")).build();
    }

    @GetMapping("/volunteers/adminView")
    public ResponseEntity<?> getUsersByAdmin() {
        return ResponseEntity.ok().body(this.userServiceImpl.getAllUsersByAdmin(Pageable.ofSize(5)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable(value = "id") UUID id){
        return ResponseEntity.ok(this.userServiceImpl.getUserById(id));
    }
    //todo: implementar as validações nos ENUMS
    @PutMapping("volunteerProfile/adminView/{id}")
    public ResponseEntity<?> updateVolunteerProfileByAdmin(@PathVariable(value = "id") UUID id, @RequestBody UserAdminEditRequest userAdminEditRequest){
       return ResponseEntity.ok().body(this.userServiceImpl.updateVolunteerProfileByAdmin(id, userAdminEditRequest));
    }
    @PatchMapping("/{id}")
    public ResponseEntity<?> updateUserProfileById(@PathVariable(value = "id") UUID id, @RequestBody @Valid UserProfileRequest userProfileRequest){
        // todo: após a tabela de stacks estiver pronta, fazer a atualização de stacks e passar essa validação para mapper
        return ResponseEntity.ok().body(this.userServiceImpl.updateEntityById(id, userProfileRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable(value = "id") UUID id){
        this.userServiceImpl.deleteEntityById(id);
        return ResponseEntity.noContent().build();
    }
}
