package com.poc.customer.dto;

import java.util.List;

public class SupplierList {

	private List<Person> personList;

	private List<Company> companyList;

	public List<Company> getCompany() {
		return companyList;
	}

	public void setCompany(List<Company> company) {
		this.companyList = company;
	}

	public List<Person> getPerson() {
		return personList;
	}

	public void setPerson(List<Person> person) {
		this.personList = person;
	}

}
