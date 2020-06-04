package com.poc.customer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.customer.dto.Company;
import com.poc.customer.dto.Person;
import com.poc.customer.model.Customer;
import com.poc.customer.model.PhoneDetails;
import com.poc.customer.model.Supplier;
import com.poc.customer.repository.CompanyRepository;
import com.poc.customer.repository.PersonRepository;

@Service
public class CustomerService {

	@Autowired
	private PersonRepository personRepository;

	public PersonRepository getPersonRepository() {
		return personRepository;
	}

	public void setPersonRepository(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@Autowired
	private CompanyRepository companyRepository;

	public CompanyRepository getCompanyRepository() {
		return companyRepository;
	}

	public void setCompanyRepository(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

	public List<Person> getPersonCustomers() {

		List<Person> personLocList = new ArrayList<Person>();

		List<com.poc.customer.model.Person> personList = personRepository.findByCustomerNotNull();

		for (com.poc.customer.model.Person person : personList) {
			Person perLoc = new Person();
			perLoc.setFirstName(person.getFirstName());
			perLoc.setLastName(person.getLastName());
			perLoc.setPhoneNumber(person.getPhonedetails().getPhoneNumber());
			perLoc.setAreaCode(person.getPhonedetails().getAreaCode());
			if (person.getCustomer() != null) {
				perLoc.setCustNumber(person.getCustomer().getCustNumber());
				perLoc.setLastOrderedDate(person.getCustomer().getLastOrderedDate());
			}
			personLocList.add(perLoc);

		}

		return personLocList;
	}

	public List<Company> getCompanyCustomers() {

		List<Company> companyLocList = new ArrayList<Company>();

		List<com.poc.customer.model.Company> compList = companyRepository.findByCustomerNotNull();

		for (com.poc.customer.model.Company company : compList) {

			Company compLoc = new Company();
			compLoc.setCompName(company.getCompName());
			compLoc.setRegNumber(company.getRegNumber());
			compLoc.setPhoneNumber(company.getPhonedetails().getPhoneNumber());
			compLoc.setAreaCode(company.getPhonedetails().getAreaCode());
			if (company.getCustomer() != null) {
				compLoc.setCustNumber(company.getCustomer().getCustNumber());
				compLoc.setLastOrderedDate(company.getCustomer().getLastOrderedDate());
			}
			companyLocList.add(compLoc);

		}

		return companyLocList;
	}

	public List<Person> getPersonSuppliers() {

		List<Person> personLocList = new ArrayList<Person>();

		List<com.poc.customer.model.Person> personList = personRepository.findBySupplierNotNull();

		for (com.poc.customer.model.Person person : personList) {
			Person perLoc = new Person();
			perLoc.setFirstName(person.getFirstName());
			perLoc.setLastName(person.getLastName());
			perLoc.setPhoneNumber(person.getPhonedetails().getPhoneNumber());
			perLoc.setAreaCode(person.getPhonedetails().getAreaCode());
			if (person.getSupplier() != null) {
				perLoc.setTaxNumber(person.getSupplier().getTaxNumber());
				perLoc.setOrderDays(person.getSupplier().getOrderDays());
			}
			personLocList.add(perLoc);

		}

		return personLocList;
	}

	public List<Company> getCompanySuppliers() {

		List<Company> companyLocList = new ArrayList<Company>();

		List<com.poc.customer.model.Company> compList = companyRepository.findBySupplierNotNull();
		for (com.poc.customer.model.Company company : compList) {
			Company compLoc = new Company();
			compLoc.setCompName(company.getCompName());
			compLoc.setRegNumber(company.getRegNumber());
			compLoc.setRegNumber(company.getRegNumber());
			compLoc.setPhoneNumber(company.getPhonedetails().getPhoneNumber());
			compLoc.setAreaCode(company.getPhonedetails().getAreaCode());
			if (company.getSupplier() != null) {
				compLoc.setTaxNumber(company.getSupplier().getTaxNumber());
				compLoc.setOrderDays(company.getSupplier().getOrderDays());
			}
			companyLocList.add(compLoc);

		}

		return companyLocList;
	}

	public void savePerson(Person person) {
		com.poc.customer.model.Person per = new com.poc.customer.model.Person();
		PhoneDetails phoneDetails = new PhoneDetails();
		Supplier supplier = new Supplier();
		supplier.setOrderDays(person.getOrderDays());
		supplier.setTaxNumber(person.getTaxNumber());
		Customer customer = new Customer();
		customer.setCustNumber(person.getCustNumber());
		customer.setLastOrderedDate(person.getLastOrderedDate());
		per.setFirstName(person.getFirstName());
		per.setLastName(person.getLastName());
		phoneDetails.setAreaCode(person.getAreaCode());
		phoneDetails.setPhoneNumber(person.getPhoneNumber());
		if (person.getCustNumber() != null) {
			per.setCustomer(customer);
		}
		if (person.getTaxNumber() != null) {
			per.setSupplier(supplier);
		}
		customer.setPerson(per);
		per.setPhonedetails(phoneDetails);
		phoneDetails.setPerson(per);
		personRepository.save(per);

	}

	public void saveCompany(Company company) {

		com.poc.customer.model.Company comp = new com.poc.customer.model.Company();
		PhoneDetails phoneDetails = new PhoneDetails();
		Customer customer = new Customer();
		Supplier supplier = new Supplier();
		supplier.setOrderDays(company.getOrderDays());
		supplier.setTaxNumber(company.getTaxNumber());
		customer.setCustNumber(company.getCustNumber());
		customer.setLastOrderedDate(company.getLastOrderedDate());
		phoneDetails.setAreaCode(company.getAreaCode());
		phoneDetails.setPhoneNumber(company.getPhoneNumber());
		comp.setCompName(company.getCompName());
		comp.setRegNumber(company.getRegNumber());
		if (company.getCustNumber() != null) {
			comp.setCustomer(customer);
		}
		if (company.getTaxNumber() != null) {
			comp.setSupplier(supplier);
		}
		comp.setPhonedetails(phoneDetails);
		phoneDetails.setCompany(comp);
		customer.setCompany(comp);
		companyRepository.save(comp);
	}

}
