package com.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.model.Customers;
import com.customer.repo.CustomersRepo;
import com.customer.exceptions.*;

@Service
public class CustomerServiceImpl implements CustomersService{

	@Autowired
	private CustomersRepo customersRepo;
	
	@Autowired
	private AccountsService accountsService;
	
	@Override
	public Customers saveCustomer(Customers customer) {
		return customersRepo.save(customer);
	}

	@Override
	public List<Customers> getAllCustomers() {
		return customersRepo.findAll();
	}

	@Override
	public Customers getCustomer(String customerId) {
		return customersRepo.findById(customerId).orElse(null);
	}

	@Override
	public Customers updateCustomer(Customers customer) {
		return customersRepo.save(customer);
	}

	@Override
	public String deleteCustomer(String customerId) {
		Customers customer=customersRepo.findById(customerId).orElse(null);
		if(customer!=null) {
			String message=accountsService.deleteAccount(customerId);
			customersRepo.delete(customer);
			return message;
		}
		return "";
	}

}
