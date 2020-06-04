package com.poc.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.customer.dto.Company;
import com.poc.customer.dto.CustomerList;
import com.poc.customer.dto.Person;
import com.poc.customer.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping(path = "/showCustomers")

	public CustomerList showCustomers() {
		List<Person> personList = customerService.getPersonCustomers();
		List<Company> compList = customerService.getCompanyCustomers();
		CustomerList custList = new CustomerList();
		custList.setPerson(personList);
		custList.setCompany(compList);
		return custList;
	}
}
