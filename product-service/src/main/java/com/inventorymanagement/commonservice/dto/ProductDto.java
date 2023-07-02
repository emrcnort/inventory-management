package com.inventorymanagement.commonservice.dto;

public record ProductDto(String name,
                         String description,
                         String price,
                         Integer stockAmount,
                         Long categoryId) {
}
