package com.inventorymanagement.commonservice.controller;

import com.inventorymanagement.commonservice.annotations.LoggableMethod;
import com.inventorymanagement.commonservice.dto.ProductDto;
import com.inventorymanagement.commonservice.model.PageableParams;
import com.inventorymanagement.commonservice.rest.BaseResponse;
import com.inventorymanagement.commonservice.rest.SuccessResponse;
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
    @LoggableMethod
    public BaseResponse<List<ProductDto>> findAllByCategoryId(@PathVariable Long categoryId,
                                                              @RequestParam(defaultValue = "0", required = false) int page,
                                                              @RequestParam(defaultValue = "5", required = false) int pageSize,
                                                              @RequestParam(defaultValue = "name", required = false) String sortBy) {
        List<ProductDto> productDtoList = productService.findAllByCategoryId(PageableParams.builder()
                .page(page)
                .pageSize(pageSize)
                .sortBy(sortBy)
                .build(), categoryId);

        return new SuccessResponse<>(productDtoList);
    }

    @Operation(summary = "Save product", description = "Saves product and returns dto model")
    @PostMapping
    @LoggableMethod
    public BaseResponse<ProductDto> save(@RequestBody ProductDto product) {
        return new SuccessResponse(productService.save(product));
    }

    @Operation(summary = "Update product", description = "Updates product and returns dto model")
    @PutMapping("/{id}")
    @LoggableMethod
    public BaseResponse<ProductDto> update(@PathVariable Long id, @RequestBody ProductDto product) {
        return new SuccessResponse(productService.update(id, product));
    }

    @Operation(summary = "Delete product", description = "Deletes product and returns dto model")
    @DeleteMapping("/{id}")
    @LoggableMethod
    public BaseResponse<ProductDto> delete(@PathVariable Long id) {
        return new SuccessResponse(productService.delete(id));
    }


}
