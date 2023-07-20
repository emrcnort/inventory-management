package com.inventorymanagement.commonservice.controller;

import com.inventorymanagement.commonservice.dto.CategoryDto;
import com.inventorymanagement.commonservice.rest.BaseResponse;
import com.inventorymanagement.commonservice.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "categories", description = "The Categories API")
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @Operation(summary = "Save category", description = "Saves category and returns dto model")
    @PostMapping
    public BaseResponse<CategoryDto> save(@RequestBody CategoryDto category) {
        return new BaseResponse<CategoryDto>(categoryService.save(category));
    }

    @Operation(summary = "Update category", description = "Updates category and returns dto model")
    @PutMapping("/{id}")
    public BaseResponse<CategoryDto> update(@PathVariable Long id, @RequestBody CategoryDto category) {
        return new BaseResponse<CategoryDto>(categoryService.update(id, category));
    }

    @Operation(summary = "Delete category", description = "Deletes category and returns dto model")
    @DeleteMapping("/{id}")
    public BaseResponse<CategoryDto> delete(@PathVariable Long id) {
        return new BaseResponse<CategoryDto>(categoryService.delete(id));
    }
}
