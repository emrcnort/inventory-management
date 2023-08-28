package com.inventorymanagement.commonservice.rest;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BaseResponse<T> {
    private T data;
    private String result;
    private String errorMessage;
    private boolean isSuccessful;
}
