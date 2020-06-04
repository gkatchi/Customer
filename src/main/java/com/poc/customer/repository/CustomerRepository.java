package com.poc.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.customer.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
