package com.ERP.Inventory_Management_Service.service;

import com.ERP.Inventory_Management_Service.model.Supplier;

import java.util.List;
import java.util.UUID;

public interface SupplierService {
    public List<Supplier> findAllSuppliers();
    public Supplier findSupplierById(UUID id);
    public void createSupplier(Supplier supplier);
    public boolean updateSupplier(UUID id, Supplier supplier);
    public boolean deleteSupplier(UUID id);
}
