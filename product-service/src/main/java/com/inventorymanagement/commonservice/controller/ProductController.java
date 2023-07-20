package com.inventorymanagement.commonservice.controller;

import com.inventorymanagement.commonservice.dto.ProductDto;
import com.inventorymanagement.commonservice.model.PageableParams;
import com.inventorymanagement.commonservice.rest.BaseResponse;
import com.inventorymanagement.commonservice.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "products", description = "The Products API")
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @Operation(summary = "Find Products by id", description = "Finds all Products by category id")
    @GetMapping(path = "/findAllByCategoryId/{categoryId}")
    public BaseResponse<List<ProductDto>> findAllByCategoryId(@PathVariable Long categoryId,
                                                              @RequestParam(defaultValue = "0", required = false) int page,
                                                              @RequestParam(defaultValue = "5", required = false) int pageSize,
                                                              @RequestParam(defaultValue = "name", required = false) String sortBy) {
        List<ProductDto> productDtoList = productService.findAllByCategoryId(PageableParams.builder()
                .page(page)
                .pageSize(pageSize)
                .sortBy(sortBy)
                .build(), categoryId);

        return new BaseResponse<>(productDtoList);
    }

    @Operation(summary = "Save product", description = "Saves product and returns dto model")
    @PostMapping
    public BaseResponse<ProductDto> save(@RequestBody ProductDto product) {
        return new BaseResponse(productService.save(product));
    }

    @Operation(summary = "Update product", description = "Updates product and returns dto model")
    @PutMapping("/{id}")
    public BaseResponse<ProductDto> update(@PathVariable Long id, @RequestBody ProductDto product) {
        return new BaseResponse(productService.update(id, product));
    }

    @Operation(summary = "Delete product", description = "Deletes product and returns dto model")
    @DeleteMapping("/{id}")
    public BaseResponse<ProductDto> delete(@PathVariable Long id) {
        return new BaseResponse(productService.delete(id));
    }


}
