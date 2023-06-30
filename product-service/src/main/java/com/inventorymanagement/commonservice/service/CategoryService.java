package com.inventorymanagement.commonservice.service;

import com.inventorymanagement.commonservice.dto.CategoryDto;
import com.inventorymanagement.commonservice.entity.Category;
import com.inventorymanagement.commonservice.exceptions.NotFoundException;
import com.inventorymanagement.commonservice.repository.CategoryRepository;
import com.inventorymanagement.commonservice.utils.mapper.CategoryMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;

    private final CategoryMapper mapper;

    @Transactional
    public void delete(Long id) {
        Optional<Category> product = Optional.ofNullable(repository.findById(id).orElseThrow(NotFoundException::new));
        repository.deleteById(product.get().getId());
    }

    public CategoryDto findById(Long id) {
        Optional<Category> category = Optional.ofNullable(repository.findById(id).orElseThrow(NotFoundException::new));
        return mapper.convertEntityToDto(category.get());
    }

    @Transactional
    public CategoryDto save(CategoryDto category) {
        return mapper.convertEntityToDto(repository.save(mapper.convertDtoToEntity(category)));
    }

    @Transactional
    public CategoryDto update(Long id, CategoryDto categoryDto) {
        Optional<Category> category = Optional.ofNullable(repository.findById(id).orElseThrow(NotFoundException::new));
        Category categoryToUpdate = category.map(e -> {
            e.setDescription(categoryDto.getDescription());
            e.setName(categoryDto.getName());
            return e;
        }).get();
        return mapper.convertEntityToDto(repository.save(categoryToUpdate));
    }
}
