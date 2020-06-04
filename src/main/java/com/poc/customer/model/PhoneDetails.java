
package com.poc.customer.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity

@Table(name = "phonedetails")
public class PhoneDetails implements Serializable {

	@Id

	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	private Integer areaCode;
	private String phoneNumber;

	@OneToOne(mappedBy = "phonedetails")
	private Person person;

	@OneToOne(mappedBy = "phonedetails")
	private Company company;

	public Integer getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(Integer areaCode) {
		this.areaCode = areaCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}
