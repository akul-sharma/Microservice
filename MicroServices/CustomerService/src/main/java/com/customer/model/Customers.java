package com.customer.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Customers {
    
	@Id
	String customerId;
	
	String name, phoneNo, address;
	
//	@Transient
//    AccountDetails accountDetails;
	
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
//	public AccountDetails getAccountDetails() {
//		return accountDetails;
//	}
//
//	public void setAccountDetails(AccountDetails accountDetails) {
//		this.accountDetails = accountDetails;
//	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
