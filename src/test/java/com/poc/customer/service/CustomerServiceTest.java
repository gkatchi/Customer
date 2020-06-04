package com.poc.customer.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.poc.customer.dto.Person;
import com.poc.customer.model.Company;
import com.poc.customer.model.Customer;
import com.poc.customer.model.PhoneDetails;
import com.poc.customer.model.Supplier;
import com.poc.customer.repository.CompanyRepository;
import com.poc.customer.repository.PersonRepository;

class CustomerServiceTest {

	@Test
	void testGetCompanySuppliers() {
		Company company = new Company();
		Supplier su = new Supplier();
		Customer cu = new Customer();
		PhoneDetails pd = new PhoneDetails();
		company.setCompName("compName");
		company.setRegNumber("123");
		company.setPhonedetails(pd);
		company.setCustomer(cu);
		company.setSupplier(su);
		List<Company> compList = new ArrayList<Company>();
		compList.add(company);
		CustomerService customerService = new CustomerService();
		CompanyRepository mock = Mockito.mock(CompanyRepository.class);
		customerService.setCompanyRepository(mock);
		Mockito.when(mock.findBySupplierNotNull()).thenReturn(compList);
		List<com.poc.customer.dto.Company> companyList = customerService.getCompanySuppliers();
		assertEquals(1, companyList.size());
	}

}
