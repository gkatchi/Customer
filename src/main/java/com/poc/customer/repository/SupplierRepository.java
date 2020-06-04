package com.poc.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.customer.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}
