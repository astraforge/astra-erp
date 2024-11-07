package com.ERP.Inventory_Management_Service.service;

import com.ERP.Inventory_Management_Service.model.Warehouse;
import java.util.List;
import java.util.UUID;

public interface WarehouseService {
    public List<Warehouse> findAllWarehouse();
    public Warehouse findWarehouseById(UUID id);
    public void createWarehouse(Warehouse warehouse);
    public boolean updateWarehouse(UUID id, Warehouse warehouseUpdated);
    public boolean deleteWarehouse(UUID id);
}
