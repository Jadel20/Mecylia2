package com.mecylia.Controller;

import com.mecylia.Service.CustomerService;
import com.mecylia.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/customer")
@RequiredArgsConstructor

public class CustomerController {
    private final CustomerService customerService;

    //Find all customers
    @GetMapping
    public List<Customer> findAll(){
        return customerService.findAll();
    }
    // Return customer by id
    @GetMapping ("{id}")
    public Customer findById(@PathVariable Long id){
        return customerService.findById(id);
    }

    // Create customer
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer create(@RequestBody Customer customer){

        return customerService.createCustomer(customer);
    }

    //Update customer
    @PutMapping ("/{id}")
    public Customer updateCustomer (@PathVariable Long id, @RequestBody Customer customer){
        return customerService.update(customer, id);
    }

    // Delete a customer
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        customerService.deleteCustomer(id);
    }
}
