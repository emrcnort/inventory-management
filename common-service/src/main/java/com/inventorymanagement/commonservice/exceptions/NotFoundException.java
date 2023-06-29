package com.inventorymanagement.commonservice.exceptions;

import org.springframework.http.HttpStatus;

public class NotFoundException extends GeneralException {
    public NotFoundException() {
        super(HttpStatus.NOT_FOUND.value());
    }

    public NotFoundException(String message) {
        super(HttpStatus.NOT_FOUND.value(), message);
    }
}
