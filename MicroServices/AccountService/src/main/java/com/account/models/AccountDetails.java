package com.account.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;



@Entity
public class AccountDetails {

	@Id
	private String customerId;

	private String ifscCode, accNo;
	
	private double balance;
	
	@Transient
	Customers customerDetails;
	
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void setCustomerDetails(Customers newCustomerDetails) {
		this.customerDetails=newCustomerDetails;
	}
	
	public Customers getCustomerDetails(){
		return customerDetails;
	}
	
}
