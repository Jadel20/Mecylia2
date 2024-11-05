package com.mecylia.Service;

import com.mecylia.Repository.CustomerRepository;
import com.mecylia.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CustomerService {

    private final CustomerRepository customerRepository;

    //Create a new customer
    public Customer createCustomer (Customer customer) {
        return customerRepository.save(customer);
    }

    //Find customer by id
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    //Find all customers
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }


    //Update a customer
    public Customer update(Customer customerToUpdate, Long id) {
        var Customer = customerRepository.findById(id);
        if (Customer.isEmpty()) {
            return null;
        }
        customerToUpdate.setId(id);
        return customerRepository.save(customerToUpdate);
    }

    //Delete a customer
        public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
    }
