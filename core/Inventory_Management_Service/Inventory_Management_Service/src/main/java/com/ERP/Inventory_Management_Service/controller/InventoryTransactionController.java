package com.ERP.Inventory_Management_Service.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ERP.Inventory_Management_Service.model.InventoryTransaction;
import com.ERP.Inventory_Management_Service.service.impl.InventoryTransactionService;

@RestController
@RequestMapping("/api/inventory-transactions")
public class InventoryTransactionController {

    private final InventoryTransactionService service;

    @Autowired
    public InventoryTransactionController(InventoryTransactionService service) {
        this.service = service;
    }

    @GetMapping
    public List<InventoryTransaction> getAllTransactions() {
        return service.getAllTransactions();
    }

    @GetMapping("/{id}")
    public InventoryTransaction getTransactionById(@PathVariable UUID id) {
        return service.getTransactionById(id);
    }

    @PostMapping
    public InventoryTransaction createTransaction(@RequestBody InventoryTransaction transaction) {
        return service.createTransaction(transaction);
    }
    @PutMapping("/{id}")
    public InventoryTransaction updateTransaction(@PathVariable UUID id, @RequestBody InventoryTransaction updatedTransaction) {
        return service.updateTransaction(id, updatedTransaction);
    }
    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable UUID id) {
        service.deleteTransaction(id);
    }
}
