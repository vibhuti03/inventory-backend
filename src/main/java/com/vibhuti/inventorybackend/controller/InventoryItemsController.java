package com.vibhuti.inventorybackend.controller;

import com.vibhuti.inventorybackend.exception.ResourceNotFoundException;
import com.vibhuti.inventorybackend.model.InventoryItems;
import com.vibhuti.inventorybackend.repositories.InventoryItemsRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

//@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {GET,PUT, POST, DELETE})
@Log4j2
@RestController
@RequestMapping("api/v1")
public class InventoryItemsController {

    @Autowired
    private InventoryItemsRepo inventoryItemsRepo;

    //To fetch list of all items in inventory
    @GetMapping("/all-inventory-items")
    public List<InventoryItems> getAllItems(){
        log.info("GET - Fetching all items in inventory");
        return inventoryItemsRepo.findAll();
    }

    //To fetch list of items by productName
    @GetMapping("/inventory-items/{productName:[a-zA-z &,]*}")
    public List<InventoryItems> getItemByName(
            @PathVariable("productName")
            String productName){
        log.info("GET - Fetching items with name: " +productName);
        List<InventoryItems> item = inventoryItemsRepo.findByProductName(productName);

        return item;
    }

    //To add an item in the inventory
    @PostMapping("add-inventory-item")
    public InventoryItems addItem(
            @RequestBody
            InventoryItems inventoryItem){
        log.info("POST - Adding inventory item" +inventoryItem.getProductName());
        return inventoryItemsRepo.save(inventoryItem);
    }

    //To update an item
    @PutMapping("/update-item/{id}")
    public ResponseEntity<InventoryItems> updateInventoryItem(
            @PathVariable
            Long id,
            @RequestBody
            InventoryItems itemDetails
    ){
        InventoryItems item = inventoryItemsRepo
                                .findById(id)
                                .orElseThrow(() -> new ResourceNotFoundException("No product with id:" +id));

        item.setProductName(itemDetails.getProductName());
        item.setProductQuantity(itemDetails.getProductQuantity());
        item.setCostPrice(itemDetails.getCostPrice());
        item.setSellPrice(itemDetails.getSellPrice());

        InventoryItems updatedItem = inventoryItemsRepo.save(item);

        log.info("PUT - Updating inventory item " +updatedItem.getProductName()+
                "with quantity:"+updatedItem.getProductQuantity()+
                "and cost price:"+updatedItem.getCostPrice()+
                "and selling price:"+updatedItem.getSellPrice());

        return ResponseEntity.ok(updatedItem);
    }
}
