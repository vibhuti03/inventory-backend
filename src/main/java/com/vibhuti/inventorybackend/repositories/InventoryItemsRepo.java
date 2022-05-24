package com.vibhuti.inventorybackend.repositories;

import com.vibhuti.inventorybackend.model.InventoryItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryItemsRepo extends JpaRepository<InventoryItems, Long> {

    List<InventoryItems> findAll();

    List<InventoryItems> findByProductName(String name);
}
