package com.poc.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.customer.dto.Company;
import com.poc.customer.dto.Person;
import com.poc.customer.dto.SupplierList;
import com.poc.customer.service.CustomerService;

@RestController
public class SupplierController {

	@Autowired
	private CustomerService customerService;

	@GetMapping(path = "/showSuppliers")

	public SupplierList showCustomers() {
		List<Person> personList = customerService.getPersonSuppliers();
		List<Company> compList = customerService.getCompanySuppliers();
		SupplierList supList = new SupplierList();
		supList.setPerson(personList);
		supList.setCompany(compList);
		return supList;
	}
}
