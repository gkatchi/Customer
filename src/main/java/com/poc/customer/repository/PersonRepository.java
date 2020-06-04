package com.poc.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.customer.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
	
	List<Person> findByCustomerNotNull();
	
	List<Person> findBySupplierNotNull();

}
