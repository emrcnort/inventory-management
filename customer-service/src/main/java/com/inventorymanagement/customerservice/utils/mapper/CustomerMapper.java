package com.inventorymanagement.customerservice.utils.mapper;

import com.inventorymanagement.commonservice.mapper.BaseMapper;
import com.inventorymanagement.customerservice.dto.CustomerDto;
import com.inventorymanagement.customerservice.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper extends BaseMapper<Customer, CustomerDto> {
    @Mapping(source = "payment.id", target = "paymentId")
    CustomerDto convertEntityToDto(Customer entity);

    @Mapping(target = "payment.id", source = "paymentId")
    Customer convertDtoToEntity(CustomerDto dto);

}
