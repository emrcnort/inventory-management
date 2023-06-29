package com.inventorymanagement.commonservice.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PageableParams {
    private int pageSize;
    private int page;
    private String sortBy;
}
