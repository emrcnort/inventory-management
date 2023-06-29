package com.inventorymanagement.commonservice.dto;

import lombok.Data;

@Data
public class ProductDto {
    private String name;
    private String description;
    private String price;
    private Integer stockAmount;
    private Long categoryId;
}
