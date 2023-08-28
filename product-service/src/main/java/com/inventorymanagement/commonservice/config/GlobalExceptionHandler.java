package com.inventorymanagement.commonservice.config;

import com.inventorymanagement.commonservice.exceptions.NotFoundException;
import com.inventorymanagement.commonservice.rest.BaseResponse;
import com.inventorymanagement.commonservice.rest.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public @ResponseBody BaseResponse handleNotFoundException(NotFoundException exception) {
        return this.generateBaseResponse(exception.getMessage());
    }

    private BaseResponse generateBaseResponse(String errorMessage) {
        return new ErrorResponse(new Object(), errorMessage);
    }
}
