package com.inventorymanagement.commonservice.rest;

public class ErrorResponse<T> extends BaseResponse<T> {
    public ErrorResponse(T data, String errorMessage) {
        super(data, GeneralConstants.ERROR, errorMessage, Boolean.FALSE);
    }
}
