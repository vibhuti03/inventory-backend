package com.vibhuti.inventorybackend.controller;

import com.vibhuti.inventorybackend.model.InventoryItems;
import com.vibhuti.inventorybackend.repositories.InventoryItemsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

//@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {GET,PUT, POST, DELETE})
@RestController
@RequestMapping("api/v1")
public class InventoryItemsController {

    @Autowired
    private InventoryItemsRepo inventoryItemsRepo;

    //To fetch list of all items in inventory
    @GetMapping("/all-inventory-items")
    public List<InventoryItems> getAllItems(){
        return inventoryItemsRepo.findAll();
    }

    //To add an item in the inventory
    @PostMapping("add-inventory-item")
    public InventoryItems addItem(
            @RequestBody
            InventoryItems inventoryItem){
        return inventoryItemsRepo.save(inventoryItem);
    }
}
