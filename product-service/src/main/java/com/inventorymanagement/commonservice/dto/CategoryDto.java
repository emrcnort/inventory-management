package com.inventorymanagement.commonservice.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CategoryDto {
    private String name;
    private String description;
    private List<ProductDto> products = new ArrayList<>();
}
