package com.inventorymanagement.customerservice.utils.mapper;

import com.inventorymanagement.commonservice.mapper.BaseMapper;
import com.inventorymanagement.customerservice.dto.PaymentDto;
import com.inventorymanagement.customerservice.entity.Payment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper extends BaseMapper<Payment, PaymentDto> {
}
