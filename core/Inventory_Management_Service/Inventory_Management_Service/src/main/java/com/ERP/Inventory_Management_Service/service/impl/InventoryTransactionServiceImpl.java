package com.ERP.Inventory_Management_Service.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ERP.Inventory_Management_Service.model.InventoryTransaction;
import com.ERP.Inventory_Management_Service.repository.InventoryTransactionRepository;
import com.ERP.Inventory_Management_Service.service.impl.InventoryTransactionService;

@Service
public class InventoryTransactionServiceImpl implements InventoryTransactionService {

    private final InventoryTransactionRepository repository;

    @Autowired
    public InventoryTransactionServiceImpl(InventoryTransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<InventoryTransaction> getAllTransactions() {
        return repository.findAll();
    }

    @Override
    public InventoryTransaction getTransactionById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Transaction not found"));
    }

    @Override
    public InventoryTransaction createTransaction(InventoryTransaction transaction) {
        return repository.save(transaction);
    }
    @Override
    public InventoryTransaction updateTransaction(UUID id, InventoryTransaction updatedTransaction) {
        InventoryTransaction existingTransaction = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        existingTransaction.setTransactionType(updatedTransaction.getTransactionType());
        existingTransaction.setQuantity(updatedTransaction.getQuantity());
        existingTransaction.setTransactionDate(updatedTransaction.getTransactionDate());
        existingTransaction.setReferenceId(updatedTransaction.getReferenceId());
        existingTransaction.setRemarks(updatedTransaction.getRemarks());

        return repository.save(existingTransaction);
    }
    @Override
    public void deleteTransaction(UUID id) {
        repository.deleteById(id);
    }
}
