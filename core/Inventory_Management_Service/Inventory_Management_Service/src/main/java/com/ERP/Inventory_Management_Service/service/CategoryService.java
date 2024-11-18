package com.ERP.Inventory_Management_Service.service;

import com.ERP.Inventory_Management_Service.model.Category;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryService {

    List<Category> getAllCategories();

    Optional<Category> getCategoryById(UUID categoryId);

    Category createCategory(Category category);

    Category updateCategory(UUID categoryId, Category category);
    void deleteCategory(UUID categoryId);
}
