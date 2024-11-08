package com.ERP.Inventory_Management_Service.controller;

import com.ERP.Inventory_Management_Service.model.Warehouse;
import com.ERP.Inventory_Management_Service.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/warehouse")
public class WarehouseController {
    private final WarehouseService warehouseService;

    @Autowired
    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @GetMapping
    public ResponseEntity<List<Warehouse>> getAllWarehouses(){
        List<Warehouse> warehouses = warehouseService.findAllWarehouse();
        return ResponseEntity.ok(warehouses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Warehouse> getWarehouseById(@PathVariable UUID id){
        Warehouse warehouse = warehouseService.findWarehouseById(id);
        if(warehouse==null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(warehouse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createWarehouse(@RequestBody Warehouse warehouse){
        warehouseService.createWarehouse(warehouse);
        return new ResponseEntity<>("Warehouse Created", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateWarehouse(@PathVariable UUID id, @RequestBody Warehouse warehouse){
        if(warehouseService.updateWarehouse(id, warehouse)){
            return new ResponseEntity<>("Warehouse Updated", HttpStatus.OK);
        }
        return new ResponseEntity<>("Warehouse Not Found (Updated)", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWarehouse(@PathVariable UUID id){
        if(warehouseService.deleteWarehouse(id)){
            return new ResponseEntity<>("Warehouse Deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>("Warehouse Not Found (Updated)", HttpStatus.NOT_FOUND);
    }
}
