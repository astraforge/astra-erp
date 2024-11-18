package com.ERP.Inventory_Management_Service.repository;

import com.ERP.Inventory_Management_Service.model.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, UUID> {
}
