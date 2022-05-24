package com.vibhuti.inventorybackend.controller;

import com.vibhuti.inventorybackend.model.InventoryItems;
import com.vibhuti.inventorybackend.repositories.InventoryItemsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class InventoryItemsController {

    @Autowired
    private InventoryItemsRepo inventoryItemsRepo;

    @GetMapping("/all-inventory-items")
    public List<InventoryItems> getAllItems(){
        return inventoryItemsRepo.findAll();
    }
}
