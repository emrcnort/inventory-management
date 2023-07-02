package com.inventorymanagement.customerservice.dto;

public record CustomerDto(String name,
                          String surname,
                          String email,
                          String phone,
                          String address,
                          String taxNumber,
                          String taxOffice,
                          Long paymentId) {
}
