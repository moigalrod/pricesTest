package com.inditex.test.infrastracture.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;

@Slf4j
@ControllerAdvice
public class ExceptionController {
    private static final String INTERNAL_ERROR = "Error en el sistema";
    private static final String FORMAT_ERROR = "El formato del Json no es correcto";


    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<Object> handleException(EntityNotFoundException e) {
        log.error("EntityNotFoundException ", e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {DataIntegrityViolationException.class})
    public ResponseEntity<Object> handleException(DataIntegrityViolationException e) {
        log.error("DataIntegrityViolationException ", e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {ConstraintViolationException.class})
    public ResponseEntity<Object> handleException(ConstraintViolationException e) {
        log.error("ConstraintViolationException ", e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
        log.error("MethodArgumentNotValidException ", e);
        StringBuilder message = new StringBuilder();
        for (ObjectError error : e.getBindingResult().getAllErrors()) {
            message.append(error.getDefaultMessage() + " ");
        }
        return new ResponseEntity(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {HttpMessageNotReadableException.class})
    public ResponseEntity<Object> handleException(HttpMessageNotReadableException e) {
        log.error("HttpMessageNotReadableException ", e);
        return new ResponseEntity(FORMAT_ERROR, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {PricesNoResultException.class})
    public ResponseEntity<Object> handleException(PricesNoResultException e) {
        log.error("PricesNoResultException ", e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleException(Exception e) {
        log.error("Exception ", e);
        return new ResponseEntity<>(INTERNAL_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
