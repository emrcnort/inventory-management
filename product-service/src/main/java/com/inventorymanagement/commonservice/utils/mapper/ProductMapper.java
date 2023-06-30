package com.inventorymanagement.commonservice.utils.mapper;

import com.inventorymanagement.commonservice.dto.ProductDto;
import com.inventorymanagement.commonservice.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper extends BaseMapper<Product, ProductDto> {
}
