package com.korit.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ValidErrorRespDto {
    private String fieldName;
    private String message;
}
