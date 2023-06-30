package com.inventorymanagement.commonservice.repository;

import com.inventorymanagement.commonservice.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
