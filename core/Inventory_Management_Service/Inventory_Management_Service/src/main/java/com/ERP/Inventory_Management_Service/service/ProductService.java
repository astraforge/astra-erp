package com.ERP.Inventory_Management_Service.service;

import com.ERP.Inventory_Management_Service.model.Product;

import java.util.List;
import java.util.UUID;


public interface ProductService {
    Product createProduct(Product product);
    Product getProductById(UUID id);
    List<Product> getAllProducts();
    Product updateProduct(UUID id, Product product);
    void deleteProduct(UUID id);
}
