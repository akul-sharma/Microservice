package com.account.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.account.models.Customers;

@FeignClient(name="CUSTOMER-SERVICE")
public interface CustomerService {
  
	@GetMapping("/customers/{customerId}")
	Customers getCustomerDetails(@PathVariable String customerId);
	
}
