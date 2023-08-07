package com.customer.service;

import java.util.List;

import com.customer.model.Customers;

public interface CustomersService {

	//Add Customer
	Customers saveCustomer(Customers customer);
	
	//Get all customers
	List<Customers> getAllCustomers();
	
	//Get a single customer
	Customers getCustomer(String customerId);
	
	//Update customer details
	Customers updateCustomer(Customers customer);
	
	//Delete a customer
	String deleteCustomer(String customerId);
	
}
