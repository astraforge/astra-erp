package com.ERP.Inventory_Management_Service.service.impl;

import com.ERP.Inventory_Management_Service.model.Supplier;
import com.ERP.Inventory_Management_Service.service.SupplierService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SupplierServiceImpl implements SupplierService {
    JpaRepository<Supplier, UUID> supplierRepository;

    public SupplierServiceImpl(JpaRepository<Supplier, UUID> supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public List<Supplier> findAllSuppliers() {
        return supplierRepository.findAll();
    }

    @Override
    public Supplier findSupplierById(UUID id) {
        return supplierRepository.findById(id).orElse(null);
    }

    @Override
    public void createSupplier(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    @Override
    public boolean updateSupplier(UUID id, Supplier updatedSupplier) {
        Optional<Supplier> oldSupplier = supplierRepository.findById(id);
        if(oldSupplier.isPresent()){
            Supplier supplier = oldSupplier.get();
            supplier.setName(updatedSupplier.getName());
            supplier.setContactInfo(updatedSupplier.getContactInfo());
            supplier.setNotes(updatedSupplier.getNotes());
            supplier.setRating(updatedSupplier.getRating());
            supplierRepository.save(supplier);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteSupplier(UUID id) {
        try{
            supplierRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
