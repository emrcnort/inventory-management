package com.inventorymanagement.commonservice.rest;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BaseResponse<T> {
    private T data;
    private String result;
    private boolean isSuccessful;

    public BaseResponse(T data) {
        this.data = data;
        this.result = GeneralConstants.SUCCESS;
        this.isSuccessful = Boolean.TRUE;
    }
}
