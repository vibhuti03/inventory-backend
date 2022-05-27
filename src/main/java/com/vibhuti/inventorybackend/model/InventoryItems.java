package com.vibhuti.inventorybackend.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "inventory_items")
public class InventoryItems {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "product_name")
    private String productName;

    @Column(name = "product_quantity")
    private int productQuantity;

    @Column(name = "cost_price")
    private int costPrice;

    @Column(name = "sell_price")
    private int sellPrice;
}
