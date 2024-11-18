package com.ERP.Inventory_Management_Service.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ERP.Inventory_Management_Service.model.InventoryTransaction;


public interface InventoryTransactionRepository extends JpaRepository<InventoryTransaction, UUID> {
}
