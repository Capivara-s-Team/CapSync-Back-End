package com.bichinhos.CapSync_Back_End.controller;


import com.bichinhos.CapSync_Back_End.dto.mapper.UserMapper;
import com.bichinhos.CapSync_Back_End.dto.request.UserRequest;
import com.bichinhos.CapSync_Back_End.entity.UserEntity;
import com.bichinhos.CapSync_Back_End.service.impl.UserServiceImpl;
import jakarta.validation.Valid;

import java.util.Optional;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserServiceImpl userServiceImpl;

    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody @Valid UserRequest userRequest){
        UserEntity transformedRequestToEntity = this.userMapper.transformRequestToEntity(userRequest);
        UserEntity entityCreatedFromService = this.userServiceImpl.createUser(transformedRequestToEntity);
        return ResponseEntity.ok().body(this.userMapper.transformEntityToResponse(entityCreatedFromService));
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

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUserById(@PathVariable(value = "id") UUID id, @RequestBody UserRequest userRequest){
        // todo: após a tabela de stacks estiver pronta, fazer a atualização de stacks
        Optional<UserRequest> userRequestOptional = Optional.ofNullable(userRequest);
        UserEntity userEntity = new UserEntity();
        userEntity.setUserPhoto(userRequestOptional.get().getUserPhoto());
        userEntity.setName(userRequestOptional.get().getName());
        userEntity.setSurname(userRequestOptional.get().getSurname());
        userEntity.setLinkedin(userRequestOptional.get().getLinkedin());
        userEntity.setDiscord(userRequestOptional.get().getDiscord());
        userEntity.setCellphone(userRequestOptional.get().getCellphone());
        return ResponseEntity.ok().body(this.userServiceImpl.updateEntityById(id, userEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable(value = "id") UUID id){
        this.userServiceImpl.deleteEntityById(id);
        return ResponseEntity.ok().build();
    }
}
