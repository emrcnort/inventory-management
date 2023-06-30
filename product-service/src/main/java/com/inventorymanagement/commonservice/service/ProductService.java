package com.inventorymanagement.commonservice.service;

import com.inventorymanagement.commonservice.dto.CategoryDto;
import com.inventorymanagement.commonservice.dto.ProductDto;
import com.inventorymanagement.commonservice.entity.Category;
import com.inventorymanagement.commonservice.entity.Product;
import com.inventorymanagement.commonservice.exceptions.NotFoundException;
import com.inventorymanagement.commonservice.model.PageableParams;
import com.inventorymanagement.commonservice.repository.ProductRepository;
import com.inventorymanagement.commonservice.utils.mapper.CategoryMapper;
import com.inventorymanagement.commonservice.utils.mapper.ProductMapper;
import jakarta.transaction.Transactional;
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

    private final CategoryService categoryService;

    private final ProductRepository repository;

    private final ProductMapper mapper;

    private final CategoryMapper categoryMapper;

    public List<ProductDto> findAllByCategoryId(PageableParams pageableParams, Long categoryId) {
        Pageable paging = PageRequest.of(pageableParams.getPage(), pageableParams.getPageSize(), Sort.by(pageableParams.getSortBy()));
        return mapper.convertEntityListToDtoList(repository.findAllByCategoryId(categoryId, paging).getContent());
    }

    @Transactional
    public ProductDto save(ProductDto product) {
        return mapper.convertEntityToDto(repository.save(mapper.convertDtoToEntity(product)));
    }

    @Transactional
    public ProductDto update(Long id, ProductDto productDto) {
        Optional<Product> product = Optional.ofNullable(repository.findById(id).orElseThrow(NotFoundException::new));
        Product productToUpdate = product.map(e -> {
            e.setDescription(productDto.getDescription());
            e.setName(productDto.getName());
            e.setPrice(productDto.getPrice());
            e.setCategory(this.getCategoryByCategoryId(productDto.getCategoryId()));
            e.setStockAmount(productDto.getStockAmount());
            return e;
        }).get();
        return mapper.convertEntityToDto(repository.save(productToUpdate));
    }

    @Transactional
    public void delete(Long id) {
        Optional<Product> product = Optional.ofNullable(repository.findById(id).orElseThrow(NotFoundException::new));
        repository.deleteById(product.get().getId());
    }

    private Category getCategoryByCategoryId(Long categoryId) {
        CategoryDto categoryDto = categoryService.findById(categoryId);
        return categoryMapper.convertDtoToEntity(categoryDto);
    }
}
