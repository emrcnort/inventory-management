package com.inventorymanagement.commonservice.utils.mapper;

import com.inventorymanagement.commonservice.dto.ProductDto;
import com.inventorymanagement.commonservice.entity.Product;
import com.inventorymanagement.commonservice.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper extends BaseMapper<Product, ProductDto> {

    @Mapping(source = "category.id", target = "categoryId")
    ProductDto convertEntityToDto(Product entity);

    @Mapping(target = "category.id", source = "categoryId")
    Product convertDtoToEntity(ProductDto dto);
}
