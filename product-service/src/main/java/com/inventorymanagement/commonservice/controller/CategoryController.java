package com.inventorymanagement.commonservice.controller;

import com.inventorymanagement.commonservice.dto.CategoryDto;
import com.inventorymanagement.commonservice.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "categories", description = "The Categories API")
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @Operation(summary = "Save category", description = "Saves category and returns dto model")
    @PostMapping
    public ResponseEntity<CategoryDto> save(@RequestBody CategoryDto category) {
        return ResponseEntity.ok(categoryService.save(category));
    }

    @Operation(summary = "Update category", description = "Updates category and returns dto model")
    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> update(@PathVariable Long id, @RequestBody CategoryDto category) {
        return ResponseEntity.ok(categoryService.update(id, category));
    }

    @Operation(summary = "Delete category", description = "Deletes category and returns dto model")
    @DeleteMapping
    public ResponseEntity delete(Long id) {
        categoryService.delete(id);
        return ResponseEntity.ok(null);
    }
    
    public ResponseEntity mockMethod(Long id) {
        return null;
    }
}
