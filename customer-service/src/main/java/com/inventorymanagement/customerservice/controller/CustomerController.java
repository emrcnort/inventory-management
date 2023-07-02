package com.inventorymanagement.customerservice.controller;

import com.inventorymanagement.customerservice.dto.CustomerDto;
import com.inventorymanagement.customerservice.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "customers", description = "the Customers API")
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @Operation(summary = "Save customer", description = "Saves customer and returns dto model")
    @PostMapping
    public ResponseEntity<CustomerDto> save(@RequestBody CustomerDto customer) {
        return ResponseEntity.ok(customerService.save(customer));
    }

    @Operation(summary = "Update customer", description = "Updates customer and returns dto model")
    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> update(@PathVariable Long id, @RequestBody CustomerDto customer) {
        return ResponseEntity.ok(customerService.update(id, customer));
    }

    @Operation(summary = "Delete customer", description = "Deletes customer and returns dto model")
    @DeleteMapping
    public ResponseEntity delete(Long id) {
        customerService.delete(id);
        return ResponseEntity.ok(null);
    }


}
