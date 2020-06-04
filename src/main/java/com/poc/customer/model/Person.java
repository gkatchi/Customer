package com.poc.customer.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity

@Table(name = "person")
public class Person implements Serializable {

	@Id

	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	private String firstName;

	private String lastName;



	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "supplier_id", referencedColumnName = "id")
    private Supplier supplier;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "phonedetails_id", referencedColumnName = "id")
    private PhoneDetails phonedetails;

	public PhoneDetails getPhonedetails() {
		return phonedetails;
	}

	public void setPhonedetails(PhoneDetails phonedetails) {
		this.phonedetails = phonedetails;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
