package com.ERP.Inventory_Management_Service.controller;

import com.ERP.Inventory_Management_Service.model.Supplier;
import com.ERP.Inventory_Management_Service.service.SupplierService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {
    SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @PostMapping
    public ResponseEntity<String> createSupplier(@RequestBody Supplier supplier){
        supplierService.createSupplier(supplier);
        return new ResponseEntity<>("Supplier Created Successfully!", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Supplier>> getAllSupplier(){
        return new ResponseEntity<>(supplierService.findAllSuppliers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable UUID id){
        Supplier supplier = supplierService.findSupplierById(id);
        if(supplier != null) return new ResponseEntity<>(supplier, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateSupplier(@PathVariable UUID id, @RequestBody Supplier supplier){
        if(supplierService.updateSupplier(id, supplier)){
            return new ResponseEntity<>("Supplier Updated Successfully!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Supplier Not Found!", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSupplier(@PathVariable UUID id){
        if(supplierService.deleteSupplier(id)){
            return new ResponseEntity<>("Supplier Deleted Successfully!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Supplier Not Found!", HttpStatus.NOT_FOUND);
    }
}
