package com.bichinhos.CapSync_Back_End.controller;


import com.bichinhos.CapSync_Back_End.dto.request.UserRequest;
import com.bichinhos.CapSync_Back_End.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody @Valid UserRequest userRequest){
        return ResponseEntity.ok().body(this.userServiceImpl.createUser(userRequest));
    }

    @GetMapping
    public ResponseEntity<?> getUsers(){
        // todo: criar um mapper que transforme a lista de usuarios retornada do banco em um objeto de resposta.
        return ResponseEntity.ok().body(this.userServiceImpl.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable(value = "id") UUID id){
        return ResponseEntity.ok(this.userServiceImpl.getUserById(id));
    }
// todo: fazer a rota de patch
//    @PatchMapping("/{id}")
//    public ResponseEntity<?> patchUserById(@PathVariable(value = "id") UUID id){
//
//    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUserById(@PathVariable(value = "id") UUID id, @RequestBody UserRequest userRequest){
        // todo: após a tabela de stacks estiver pronta, fazer a atualização de stacks e passar essa validação para mapper
        return ResponseEntity.ok().body(this.userServiceImpl.updateEntityById(id, userRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable(value = "id") UUID id){
        this.userServiceImpl.deleteEntityById(id);
        return ResponseEntity.ok().build();
    }
}
