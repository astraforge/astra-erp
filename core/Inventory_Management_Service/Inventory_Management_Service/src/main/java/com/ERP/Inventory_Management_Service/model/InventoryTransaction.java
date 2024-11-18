package com.ERP.Inventory_Management_Service.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class InventoryTransaction {

    @Id
    @GeneratedValue
    private UUID transactionId;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    private Integer quantity;
    private LocalDateTime transactionDate;
    private UUID referenceId;
    private String remarks;



    // Getters and setters omitted for brevity

    public enum TransactionType {
        ADDITION, REMOVAL, TRANSFER
    }



    public UUID getTransactionId() {
        return transactionId;
    }



    public void setTransactionId(UUID transactionId) {
        this.transactionId = transactionId;
    }



    public TransactionType getTransactionType() {
        return transactionType;
    }



    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }



    public Integer getQuantity() {
        return quantity;
    }



    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }



    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }



    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }



    public UUID getReferenceId() {
        return referenceId;
    }



    public void setReferenceId(UUID referenceId) {
        this.referenceId = referenceId;
    }



    public String getRemarks() {
        return remarks;
    }



    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    


}
