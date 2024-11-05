package com.mecylia.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    private String customerName; no need to repeat the info that is in customer already
    private int itemId;
    private String itemName;
    private int quantity;
    private double price;

    public Cart(int itemId, String itemName, int quantity, double price, Customer customer, List<Item> items) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.customer = customer;
        this.items = items;
    }

    @OneToOne(mappedBy = "cart")
    private Customer customer;

    @ManyToMany
    private List<Item> items = new ArrayList<>();


    public void addItemToCart(Item item) {
        this.items.add(item);
        item.getCarts().add(this);
    }

    public Cart(Customer customer) {
        this.customer = customer;
    }
}


