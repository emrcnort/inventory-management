package com.inventorymanagement.commonservice.controller;

import com.inventorymanagement.commonservice.dto.CategoryDto;
import com.inventorymanagement.commonservice.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDto> save(@RequestBody CategoryDto category) {
        return ResponseEntity.ok(categoryService.save(category));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> update(@PathVariable Long id, @RequestBody CategoryDto category) {
        return ResponseEntity.ok(categoryService.update(id, category));
    }

    @DeleteMapping
    public ResponseEntity delete(Long id) {
        categoryService.delete(id);
        return ResponseEntity.ok(null);
    }
}
