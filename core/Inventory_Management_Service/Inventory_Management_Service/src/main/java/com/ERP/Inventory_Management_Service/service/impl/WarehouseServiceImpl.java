package com.ERP.Inventory_Management_Service.service.impl;

import com.ERP.Inventory_Management_Service.model.Warehouse;
import com.ERP.Inventory_Management_Service.repository.WarehouseRepository;
import com.ERP.Inventory_Management_Service.service.WarehouseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class WarehouseServiceImpl implements WarehouseService {
    private WarehouseRepository warehouseRepository;

    public WarehouseServiceImpl(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    @Override
    public List<Warehouse> findAllWarehouse() {
        return warehouseRepository.findAll();
    }

    @Override
    public Warehouse findWarehouseById(UUID id) {
        return warehouseRepository.findById(id).orElse(null);
    }

    @Override
    public void createWarehouse(Warehouse warehouse) {
        warehouseRepository.save(warehouse);
    }

    @Override
    public boolean updateWarehouse(UUID id, Warehouse warehouseUpdated) {
        Optional<Warehouse> warehouse = warehouseRepository.findById(id);
        if (warehouse.isPresent()) {
            Warehouse updatedWarehouse = warehouse.get();
            updatedWarehouse.setName(warehouseUpdated.getName());
            updatedWarehouse.setAddress(warehouseUpdated.getAddress());
            updatedWarehouse.setCapacity(warehouseUpdated.getCapacity());
            updatedWarehouse.setStatus(warehouseUpdated.getStatus());
            updatedWarehouse.setManagerId(warehouseUpdated.getManagerId());
            warehouseRepository.save(updatedWarehouse);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteWarehouse(UUID id) {
        try{
            warehouseRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
