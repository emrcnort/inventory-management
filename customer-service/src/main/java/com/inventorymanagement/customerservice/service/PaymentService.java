package com.inventorymanagement.customerservice.service;

import com.inventorymanagement.commonservice.exceptions.NotFoundException;
import com.inventorymanagement.customerservice.dto.PaymentDto;
import com.inventorymanagement.customerservice.entity.Payment;
import com.inventorymanagement.customerservice.repository.PaymentRepository;
import com.inventorymanagement.customerservice.utils.mapper.PaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository repository;

    private final PaymentMapper mapper;


    public PaymentDto findById(Long id) {
        Optional<Payment> payment = Optional.ofNullable(repository.findById(id).orElseThrow(NotFoundException::new));
        return mapper.convertEntityToDto(payment.get());
    }
}
