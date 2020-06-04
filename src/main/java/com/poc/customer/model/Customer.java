package com.poc.customer.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

@Entity

@Table(name = "customer")
public class Customer implements Serializable {

	@Id

	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String custNumber;
	Date lastOrderedDate;

	@OneToOne(mappedBy = "customer")
    private Person person;
	
	@OneToOne(mappedBy = "customer")
    private Company company;

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getCustNumber() {
		return custNumber;
	}

	public void setCustNumber(String custNumber) {
		this.custNumber = custNumber;
	}

	public Date getLastOrderedDate() {
		return lastOrderedDate;
	}

	public void setLastOrderedDate(Date lastOrderedDate) {
		this.lastOrderedDate = lastOrderedDate;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
