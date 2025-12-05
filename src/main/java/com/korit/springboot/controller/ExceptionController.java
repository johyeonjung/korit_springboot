package com.korit.springboot.controller;
import com.korit.springboot.dto.ValidErrorRespDto;
import com.korit.springboot.exception.DuplicatedException;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.DuplicateFormatFlagsException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<String> duplicatedException(SQLIntegrityConstraintViolationException e) {
        e.printStackTrace();
        return ResponseEntity.badRequest().body(e.getMessage());
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ValidErrorRespDto>> validException(MethodArgumentNotValidException e) {
//        Map<String, String> errorMap = new LinkedHashMap<>();
//        e.getFieldErrors().forEach(error ->  {
//            errorMap.put(error.getField(), error.getDefaultMessage());
//        });

        List<ValidErrorRespDto> errors = e.getFieldErrors()
                .stream()
                .map(error -> new ValidErrorRespDto(error.getField(), error.getDefaultMessage()))
                .toList();

        return ResponseEntity.badRequest().body(errors);
    }
    @ExceptionHandler(DuplicatedException.class)
    public ResponseEntity<ValidErrorRespDto> duplicatedException(DuplicatedException e)
    {
        return ResponseEntity.badRequest().body(e.getValidErrorRespDto());
    }
}
