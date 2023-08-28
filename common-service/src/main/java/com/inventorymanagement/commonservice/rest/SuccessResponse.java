package com.inventorymanagement.commonservice.rest;

import org.apache.commons.lang3.StringUtils;

public class SuccessResponse<T> extends BaseResponse<T> {
    public SuccessResponse(T data) {
        super(data, GeneralConstants.SUCCESS, StringUtils.EMPTY, Boolean.TRUE);
    }
}
