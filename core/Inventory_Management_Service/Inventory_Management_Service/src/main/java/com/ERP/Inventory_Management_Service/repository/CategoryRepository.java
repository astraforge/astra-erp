package com.ERP.Inventory_Management_Service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ERP.Inventory_Management_Service.model.Category;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
    // Additional query methods (if needed)
}
