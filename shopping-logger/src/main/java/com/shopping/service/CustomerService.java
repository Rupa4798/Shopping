package com.shopping.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.entity.Customer;
import com.shopping.exception.CustomerNotFoundException;
import com.shopping.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: " + id));
    }

    public Customer addCustomer(Customer customer) {
        // Additional validation or business logic can be added here
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        Customer existingCustomer = getCustomerById(id);

        // Update fields based on your requirements
        existingCustomer.setcName(updatedCustomer.getcName());
        existingCustomer.setcAddress(updatedCustomer.getcAddress());
        existingCustomer.setcContact(updatedCustomer.getcContact());

        // Additional validation or business logic can be added here

        return customerRepository.save(existingCustomer);
    }
}