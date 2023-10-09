package com.alexis.nexos.credibanco.bankinc.controller;

import com.alexis.nexos.credibanco.bankinc.exception.InsufficientBalanceException;
import com.alexis.nexos.credibanco.bankinc.exception.NotFoundException;
import com.alexis.nexos.credibanco.bankinc.exception.TransactionNotVoidedException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException ex) {

        List<String> errorMessages = ex.getConstraintViolations()
                .stream()
                .map(violation -> violation.getMessage())
                .collect(Collectors.toList());

        String errorMessage = String.join(", ", errorMessages);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Errores de validación: " + errorMessage);
    }

    @ExceptionHandler(InsufficientBalanceException.class)
    public ResponseEntity<String> handleInsufficientBalanceException(InsufficientBalanceException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(TransactionNotVoidedException.class)
    public ResponseEntity<String> handleTransactionNotVoidedException(TransactionNotVoidedException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No tienes conexión a internet, Ops!");
    }


}
