package com.poc.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poc.customer.dto.Company;
import com.poc.customer.service.CustomerService;

@RestController
public class CompanyController {

	
	@Autowired
	private CustomerService customerService;

	@PostMapping(path = "/addCompany", consumes = "application/json", produces = "application/json")
	public void savePerson(@RequestBody Company company) {

		customerService.saveCompany(company);

	}

}
