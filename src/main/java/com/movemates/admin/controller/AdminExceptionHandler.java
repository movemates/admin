package com.movemates.admin.controller;

import com.movemates.admin.model.AdminErrorResponse;
import com.movemates.admin.model.exception.UserAlreadyExistException;
import com.movemates.admin.model.exception.UserNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.UUID;

@ControllerAdvice
public class AdminExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<AdminErrorResponse> handleUserNotFoundException(HttpServletRequest req, UserNotFoundException userNotFoundException) {
        AdminErrorResponse error = AdminErrorResponse.builder()
                .ref(UUID.randomUUID())
                .error(UserNotFoundException.class.toString())
                .errorMessage(userNotFoundException.getMessage())
                .build();
        return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<AdminErrorResponse> handleUserAlreadyExistException(HttpServletRequest req, UserAlreadyExistException userAlreadyExistException) {
        AdminErrorResponse error = AdminErrorResponse.builder()
                .ref(UUID.randomUUID())
                .error(UserAlreadyExistException.class.toString())
                .errorMessage(userAlreadyExistException.getMessage())
                .build();
        return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.FORBIDDEN);
    }
}
