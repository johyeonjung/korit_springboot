package com.korit.springboot.exception;

import com.korit.springboot.dto.ValidErrorRespDto;
import jakarta.validation.Valid;
import lombok.Getter;


public class DuplicatedException extends RuntimeException {
    @Getter
    private ValidErrorRespDto validErrorRespDto;

    public DuplicatedException(String fieldName, String message) {
        super(message);
        this.validErrorRespDto = new ValidErrorRespDto(fieldName, message);
    }
}

