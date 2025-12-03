package com.korit.springboot.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ReqFormDataDto {
    private String name;
    private int age;
    private MultipartFile file;
}
