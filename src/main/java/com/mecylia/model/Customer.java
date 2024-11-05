package com.mecylia.model;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Customer extends User {

    private String firstName;
    private String lastName;
    private int dateOfBirth;
    private String email;
    private String address;
    private String city;
    private int phoneNumber;
    private int creditCardNumber;

    public Customer(String firstName, String lastName, int dateOfBirth, String email, String address, String city, int phoneNumber, int creditCardNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.creditCardNumber = creditCardNumber;
    }

    @OneToMany(mappedBy = "customer")
    private List<SalesOrder> salesOrders;

    @OneToOne
    private Cart cart;


}

