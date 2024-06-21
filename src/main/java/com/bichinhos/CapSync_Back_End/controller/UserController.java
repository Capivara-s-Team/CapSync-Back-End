package com.bichinhos.CapSync_Back_End.controller;


import com.bichinhos.CapSync_Back_End.dto.mapper.UserMapper;
import com.bichinhos.CapSync_Back_End.dto.request.UserRequest;
import com.bichinhos.CapSync_Back_End.entity.UserEntity;
import com.bichinhos.CapSync_Back_End.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
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
        UserEntity userEntity = this.userMapper.transformRequestToEntity(userRequest);
        UserEntity entityCreatedFromService = this.userServiceImpl.createUser(userEntity);
        return ResponseEntity.ok().body(this.userMapper.transformEntityToResponse(entityCreatedFromService));
    }
    @GetMapping
    public ResponseEntity<?> readUser(){
        return ResponseEntity.ok().body("Sucesso");
    }
    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody @Valid UserRequest userRequest){
        return ResponseEntity.ok().body("Sucesso");
    }
    @DeleteMapping
    public ResponseEntity<?> deleteUser(@RequestBody @Valid UserRequest userRequest){
        return ResponseEntity.ok().body("Sucesso");
    }
}
