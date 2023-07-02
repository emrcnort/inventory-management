package com.inventorymanagement.commonservice.dto;

import java.util.List;

public record CategoryDto(String name, String description, List<ProductDto> products) {
}
