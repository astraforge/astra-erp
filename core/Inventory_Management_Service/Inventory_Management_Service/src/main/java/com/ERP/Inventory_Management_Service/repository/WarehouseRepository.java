package com.ERP.Inventory_Management_Service.repository;

import com.ERP.Inventory_Management_Service.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WarehouseRepository extends JpaRepository<Warehouse, UUID> {
}
