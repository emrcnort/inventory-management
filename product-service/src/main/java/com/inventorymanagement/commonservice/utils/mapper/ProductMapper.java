package com.inventorymanagement.commonservice.utils.mapper;

import com.inventorymanagement.commonservice.dto.ProductDto;
import com.inventorymanagement.commonservice.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product convertDtoToEntity(ProductDto dto);

    ProductDto convertEntityToDto(Product entity);

    List<Product> convertDtoListToEntityList(List<ProductDto> dtoList);

    List<ProductDto> convertEntityListToDtoList(List<Product> entities);
}
