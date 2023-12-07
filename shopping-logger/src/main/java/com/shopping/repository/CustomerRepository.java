package com.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Additional query methods if needed
}
