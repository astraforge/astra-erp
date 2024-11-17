package com.ERP.Inventory_Management_Service.repository;

import com.ERP.Inventory_Management_Service.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SupplierRepository extends JpaRepository<Supplier, UUID> {
}
