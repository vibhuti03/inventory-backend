package com.vibhuti.inventorybackend.repositories;

import com.vibhuti.inventorybackend.model.InventoryItems;

import java.util.List;

public interface InventoryItemsRepo {

    List<InventoryItems> findAll();

    List<InventoryItems> findByName(String name);
}
