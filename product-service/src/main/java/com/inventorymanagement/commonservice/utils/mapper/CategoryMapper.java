package com.inventorymanagement.commonservice.utils.mapper;

import com.inventorymanagement.commonservice.dto.CategoryDto;
import com.inventorymanagement.commonservice.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends BaseMapper<Category, CategoryDto> {
}
