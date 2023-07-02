package com.inventorymanagement.customerservice.controller;

import com.inventorymanagement.customerservice.dto.CustomerDto;
import com.inventorymanagement.customerservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDto> save(@RequestBody CustomerDto customer) {
        return ResponseEntity.ok(customerService.save(customer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> update(@PathVariable Long id, @RequestBody CustomerDto customer) {
        return ResponseEntity.ok(customerService.update(id, customer));
    }

    @DeleteMapping
    public ResponseEntity delete(Long id) {
        customerService.delete(id);
        return ResponseEntity.ok(null);
    }


}
