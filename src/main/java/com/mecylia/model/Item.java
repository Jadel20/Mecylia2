package com.mecylia.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter


public class Item {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 private String title;
 private String description;

 @Enumerated(EnumType.STRING)
 private ItemSize itemSize;


 private String color;
 private Double price;
 private int quantityAvailable;


 public Item(String title, String description, ItemSize itemSize, String color, Double price, int quantityAvailable) {
  this.title = title;
  this.description = description;
  this.itemSize = itemSize;
  this.color = color;
  this.price = price;
  this.quantityAvailable = quantityAvailable;
 }


@ManyToMany
 private Set<Cart> carts = new HashSet<Cart>();

@ManyToMany (mappedBy = "items")
private List<SalesOrder> salesOrders;
}
