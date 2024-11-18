package com.ERP.Inventory_Management_Service.service.impl;

import com.ERP.Inventory_Management_Service.model.PurchaseOrder;
import com.ERP.Inventory_Management_Service.repository.PurchaseOrderRepository;
import com.ERP.Inventory_Management_Service.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private final PurchaseOrderRepository purchaseOrderRepository;

    @Autowired
    public PurchaseOrderServiceImpl(PurchaseOrderRepository purchaseOrderRepository) {
        this.purchaseOrderRepository = purchaseOrderRepository;
    }

    @Override
    public List<PurchaseOrder> getAllPurchaseOrders() {
        return purchaseOrderRepository.findAll();
    }

    @Override
    public Optional<PurchaseOrder> getPurchaseOrderById(UUID orderId) {
        return purchaseOrderRepository.findById(orderId);
    }

    @Override
    public PurchaseOrder createPurchaseOrder(PurchaseOrder purchaseOrder) {
        return purchaseOrderRepository.save(purchaseOrder);
    }

    @Override
    public PurchaseOrder updatePurchaseOrder(UUID orderId, PurchaseOrder purchaseOrder) {
        return purchaseOrderRepository.findById(orderId).map(existingOrder -> {
            existingOrder.setSupplierId(purchaseOrder.getSupplierId());
            existingOrder.setOrderDate(purchaseOrder.getOrderDate());
            existingOrder.setExpectedDeliveryDate(purchaseOrder.getExpectedDeliveryDate());
            existingOrder.setStatus(purchaseOrder.getStatus());
            existingOrder.setTotalAmount(purchaseOrder.getTotalAmount());
            return purchaseOrderRepository.save(existingOrder);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));
    }

    @Override
    public void deletePurchaseOrder(UUID orderId) {
        purchaseOrderRepository.deleteById(orderId);
    }
}
