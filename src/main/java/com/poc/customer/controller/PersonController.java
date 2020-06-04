package com.poc.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poc.customer.dto.Person;
import com.poc.customer.service.CustomerService;

@RestController
public class PersonController {

	@Autowired
	private CustomerService customerService;

	@PostMapping(path = "/addPerson", consumes = "application/json", produces = "application/json")
	public void savePerson(@RequestBody Person person) {

		customerService.savePerson(person);

	}

}
