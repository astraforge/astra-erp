package com.ERP.Inventory_Management_Service.service;

import java.util.List;
import java.util.UUID;

import com.ERP.Inventory_Management_Service.model.InventoryTransaction;

public interface InventoryTransactionService {
    List<InventoryTransaction> getAllTransactions();
    InventoryTransaction getTransactionById(UUID id);
    InventoryTransaction createTransaction(InventoryTransaction transaction);
    InventoryTransaction updateTransaction(UUID id, InventoryTransaction updatedTransaction);
    void deleteTransaction(UUID id);
}
