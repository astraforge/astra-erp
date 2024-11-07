package com.ERP.Inventory_Management_Service.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
//@Table(name = "table_warehouse")
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID warehouseId;
    private String name;
    private String address;
    private Integer capacity;
    private UUID managerId;
    private Status status;

    public Warehouse() {

    }

    public Warehouse(UUID warehouseId, String name, String address, Integer capacity, UUID managerId, Status status) {
        this.warehouseId = warehouseId;
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.managerId = managerId;
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public UUID getManagerId() {
        return managerId;
    }

    public void setManagerId(UUID managerId) {
        this.managerId = managerId;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(UUID warehouseId) {
        this.warehouseId = warehouseId;
    }
}
