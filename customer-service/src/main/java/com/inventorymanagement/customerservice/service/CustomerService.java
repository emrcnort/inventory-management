package com.inventorymanagement.customerservice.service;

import com.inventorymanagement.commonservice.exceptions.NotFoundException;
import com.inventorymanagement.customerservice.dto.CustomerDto;
import com.inventorymanagement.customerservice.dto.PaymentDto;
import com.inventorymanagement.customerservice.entity.Customer;
import com.inventorymanagement.customerservice.entity.Payment;
import com.inventorymanagement.customerservice.repository.CustomerRepository;
import com.inventorymanagement.customerservice.utils.mapper.CustomerMapper;
import com.inventorymanagement.customerservice.utils.mapper.PaymentMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;
    private final PaymentMapper paymentMapper;
    private final PaymentService paymentService;

    @Transactional
    public CustomerDto delete(Long id) {
        Optional<Customer> customer = Optional.ofNullable(repository.findById(id).orElseThrow(NotFoundException::new));
        repository.deleteById(customer.get().getId());
        return mapper.convertEntityToDto(customer.get());
    }

    public CustomerDto findById(Long id) {
        Optional<Customer> customer = Optional.ofNullable(repository.findById(id).orElseThrow(NotFoundException::new));
        return mapper.convertEntityToDto(customer.get());
    }

    @Transactional
    public CustomerDto save(CustomerDto customer) {
        return mapper.convertEntityToDto(repository.save(mapper.convertDtoToEntity(customer)));
    }

    @Transactional
    public CustomerDto update(Long id, CustomerDto customerDto) {
        Optional<Customer> customer = Optional.ofNullable(repository.findById(id).orElseThrow(NotFoundException::new));
        Customer customerToUpdate = customer.map(e -> {
            e.setAddress(customerDto.address());
            e.setName(customerDto.name());
            e.setSurname(customerDto.email());
            e.setSurname(customerDto.surname());
            e.setPhone(customerDto.phone());
            e.setPayment(this.getPaymentByPaymentId(customerDto.paymentId()));
            e.setTaxNumber(customerDto.taxNumber());
            e.setTaxOffice(customerDto.taxOffice());
            return e;
        }).get();
        return mapper.convertEntityToDto(repository.save(customerToUpdate));
    }

    private Payment getPaymentByPaymentId(Long paymentId) {
        PaymentDto paymentDto = paymentService.findById(paymentId);
        return paymentMapper.convertDtoToEntity(paymentDto);
    }

}
