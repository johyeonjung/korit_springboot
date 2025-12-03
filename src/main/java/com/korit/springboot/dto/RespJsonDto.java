package com.korit.springboot.dto;

import lombok.Data;

import java.util.List;

@Data
public class RespJsonDto {
    private String name;
    private String email;
    private List<String> strs;
    private RespJsonDto2 respJsonDto2;
}
