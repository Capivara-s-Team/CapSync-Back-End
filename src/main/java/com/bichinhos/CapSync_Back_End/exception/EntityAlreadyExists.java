package com.bichinhos.CapSync_Back_End.exception;

public class EntityAlreadyExists extends RuntimeException{
    public EntityAlreadyExists(String message) {
        super(message);
    }
}
