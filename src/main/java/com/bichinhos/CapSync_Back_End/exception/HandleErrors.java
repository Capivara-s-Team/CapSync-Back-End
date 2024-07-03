package com.bichinhos.CapSync_Back_End.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice()
public class HandleErrors {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleValidationExceptions(
            MethodArgumentNotValidException ex, HttpServletRequest request) {

        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        Map<String, String> fieldErrorsMap = fieldErrors.stream()
                .collect(Collectors.toMap(FieldError::getField,
                        error -> error.getDefaultMessage() != null ? error.getDefaultMessage() : "Field error"));
        String fields = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(", "));

        ProblemDetail problemDetail = ProblemDetail
                .forStatusAndDetail(HttpStatus.BAD_REQUEST, "Check the field(s) error(s): " + fields );

        problemDetail.setType(URI.create("https://example.net/errors/bad-request-exception"));
        problemDetail.setTitle("Bad Request Exception, invalid fields");
        problemDetail.setProperty("timeStamp", LocalDateTime.now());
        problemDetail.setProperty("errors", fieldErrorsMap);

        return problemDetail;
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ProblemDetail handleEntityNotFound(EntityNotFoundException error, HttpServletRequest request){
        ProblemDetail problemDetail = ProblemDetail
                .forStatusAndDetail(HttpStatus.NOT_FOUND, error.getMessage());
        problemDetail.setTitle("Usuario não encontrado");
        problemDetail.setProperty("timeStamp", LocalDateTime.now());
        problemDetail.setType(URI.create("errors/user-not-found"));
        return problemDetail;
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ProblemDetail handleUUIDInvalid(MethodArgumentTypeMismatchException error, HttpServletRequest request){
        ProblemDetail problemDetail = ProblemDetail
                .forStatusAndDetail(HttpStatus.BAD_REQUEST, error.getMessage());
        problemDetail.setTitle("UUID invalido");
        problemDetail.setProperty("timeStamp", LocalDateTime.now());
        problemDetail.setType(URI.create("errors/invalid-UUID"));
        return problemDetail;
    }

    @ExceptionHandler(EntityAlreadyExists.class)
    public ProblemDetail handleUserWhoExists(EntityAlreadyExists error, HttpServletRequest request){
        ProblemDetail problemDetail = ProblemDetail
                .forStatusAndDetail(HttpStatus.BAD_REQUEST, error.getMessage());
        problemDetail.setTitle("Usuario ja existente");
        problemDetail.setProperty("timeStamp", LocalDateTime.now());
        problemDetail.setType(URI.create("errors/user-already-exists"));
        return problemDetail;
    }
}
