package com.poc.customer.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Company {

	private String compName;

	private String regNumber;

	private String custNumber;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/mm/yyyy")
	private Date lastOrderedDate;

	private String taxNumber;

	private Integer orderDays;
	
	private Integer areaCode;
	
	private String phoneNumber;

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

	public String getCustNumber() {
		return custNumber;
	}

	public String getTaxNumber() {
		return taxNumber;
	}

	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}

	public Integer getOrderDays() {
		return orderDays;
	}

	public void setOrderDays(Integer orderDays) {
		this.orderDays = orderDays;
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

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}

}
