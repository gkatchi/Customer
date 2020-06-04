package com.poc.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.customer.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

	List<Company> findByCustomerNotNull();

	List<Company> findBySupplierNotNull();

}
