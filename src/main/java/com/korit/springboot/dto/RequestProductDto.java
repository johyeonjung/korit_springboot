package com.korit.springboot.dto;

import lombok.Data;

@Data
public class RequestProductDto {
    private String product_name;
    private String size;
    private int price;
}
