package com.inventorymanagement.customerservice.controller;

import com.inventorymanagement.commonservice.rest.BaseResponse;
import com.inventorymanagement.commonservice.rest.SuccessResponse;
import com.inventorymanagement.customerservice.dto.CustomerDto;
import com.inventorymanagement.customerservice.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "customers", description = "the Customers API")
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @Operation(summary = "Save customer", description = "Saves customer and returns dto model")
    @PostMapping
    public BaseResponse<CustomerDto> save(@RequestBody CustomerDto customer) {
        return new SuccessResponse<>(customerService.save(customer));
    }

    @Operation(summary = "Update customer", description = "Updates customer and returns dto model")
    @PutMapping("/{id}")
    public BaseResponse<CustomerDto> update(@PathVariable Long id, @RequestBody CustomerDto customer) {
        return new SuccessResponse<>(customerService.update(id, customer));
    }

    @Operation(summary = "Delete customer", description = "Deletes customer and returns dto model")
    @DeleteMapping
    public BaseResponse<CustomerDto> delete(Long id) {
        return new SuccessResponse(customerService.delete(id));
    }


}
