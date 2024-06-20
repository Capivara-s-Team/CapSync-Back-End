package com.bichinhos.CapSync_Back_End.controller;


import com.bichinhos.CapSync_Back_End.dto.request.UserRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping
    public ResponseEntity<?> saveUserController(@RequestBody @Valid UserRequest userRequest){
        return ResponseEntity.ok().body("Sucesso");
    }
    @GetMapping
    public ResponseEntity<?> readUserController(){
        return ResponseEntity.ok().body("Sucesso");
    }
    @PutMapping
    public ResponseEntity<?> updateUserController(@RequestBody @Valid UserRequest userRequest){
        return ResponseEntity.ok().body("Sucesso");
    }
    @DeleteMapping
    public ResponseEntity<?> deleteUserController(@RequestBody @Valid UserRequest userRequest){
        return ResponseEntity.ok().body("Sucesso");
    }
}
