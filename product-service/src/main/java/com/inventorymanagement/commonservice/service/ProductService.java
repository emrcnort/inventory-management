package com.inventorymanagement.commonservice.service;

import com.inventorymanagement.commonservice.dto.ProductDto;
import com.inventorymanagement.commonservice.entity.Product;
import com.inventorymanagement.commonservice.exceptions.NotFoundException;
import com.inventorymanagement.commonservice.model.PageableParams;
import com.inventorymanagement.commonservice.repository.ProductRepository;
import com.inventorymanagement.commonservice.utils.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    private final ProductMapper mapper;

    public List<ProductDto> findAllByCategoryId(PageableParams pageableParams, Long categoryId) {
        Pageable paging = PageRequest.of(pageableParams.getPage(), pageableParams.getPageSize(), Sort.by(pageableParams.getSortBy()));
        return mapper.convertEntityListToDtoList(repository.findAllByCategoryId(categoryId, paging).getContent());
    }

    public ProductDto save(ProductDto product) {
        return mapper.convertEntityToDto(repository.save(mapper.convertDtoToEntity(product)));
    }

    public ProductDto update(Long id, ProductDto productDto) {
        Optional<Product> product = Optional.ofNullable(repository.findById(id).orElseThrow(NotFoundException::new));
        Product productToUpdate = product.map(e -> {
            e.setDescription(productDto.getDescription());
            e.setName(productDto.getName());
            e.setPrice(productDto.getPrice());
            e.setCategoryId(productDto.getCategoryId());
            e.setStockAmount(productDto.getStockAmount());
            return e;
        }).get();
        return mapper.convertEntityToDto(repository.save(productToUpdate));
    }
}
