package com.inventorymanagement.commonservice.controller;

import com.inventorymanagement.commonservice.dto.ProductDto;
import com.inventorymanagement.commonservice.model.PageableParams;
import com.inventorymanagement.commonservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping(path = "/findAllByCategoryId/{categoryId}")
    public ResponseEntity<List<ProductDto>> findAllByCategoryId(@PathVariable Long categoryId,
                                                                @RequestParam(defaultValue = "0", required = false) int page,
                                                                @RequestParam(defaultValue = "5", required = false) int pageSize,
                                                                @RequestParam(defaultValue = "name", required = false) String sortBy) {
        return new ResponseEntity<>(productService.findAllByCategoryId(PageableParams.builder()
                .page(page)
                .pageSize(pageSize)
                .sortBy(sortBy)
                .build(), categoryId), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<ProductDto> save(@RequestBody ProductDto product) {
        return ResponseEntity.ok(productService.save(product));
    }

    @PutMapping("/{id]")
    public ResponseEntity<ProductDto> update(@PathVariable Long id, @RequestBody ProductDto product) {
        return ResponseEntity.ok(productService.update(id, product));
    }

}
