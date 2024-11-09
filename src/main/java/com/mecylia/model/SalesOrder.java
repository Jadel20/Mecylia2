package com.mecylia.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter


public class SalesOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String address;
    private String trackingNumber;
    private String status;
    private double totalPrice;

    public SalesOrder(String address, String trackingNumber, String status, double totalPrice) {

        this.address = address;
        this.trackingNumber = trackingNumber;
        this.status = status;
        this.totalPrice = totalPrice;
    }


    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToMany
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Long itemId) {
        items.removeIf(item -> item.getId().equals(itemId));
    }

}


