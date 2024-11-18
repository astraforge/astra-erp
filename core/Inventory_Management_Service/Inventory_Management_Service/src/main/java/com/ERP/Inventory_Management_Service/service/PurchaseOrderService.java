package com.ERP.Inventory_Management_Service.service;

import com.ERP.Inventory_Management_Service.model.PurchaseOrder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PurchaseOrderService {

    List<PurchaseOrder> getAllPurchaseOrders();

    Optional<PurchaseOrder> getPurchaseOrderById(UUID orderId);

    PurchaseOrder createPurchaseOrder(PurchaseOrder purchaseOrder);

    PurchaseOrder updatePurchaseOrder(UUID orderId, PurchaseOrder purchaseOrder);

    void deletePurchaseOrder(UUID orderId);
}
