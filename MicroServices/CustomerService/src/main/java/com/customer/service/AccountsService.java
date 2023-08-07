package com.customer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="ACCOUNT-SERVICE")
public interface AccountsService {

	@DeleteMapping("/accounts/{customerId}")
	String deleteAccount(@PathVariable String customerId);
	
}
