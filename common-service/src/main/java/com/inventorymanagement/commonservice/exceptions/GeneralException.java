package com.inventorymanagement.commonservice.exceptions;

public class GeneralException extends RuntimeException {
    private final int status;

    public GeneralException(int status) {
        super();
        this.status = status;
    }

    public GeneralException(int status, String message) {
        super(message);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
