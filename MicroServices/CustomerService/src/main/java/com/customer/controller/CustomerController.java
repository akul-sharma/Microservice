package com.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.customer.exceptions.ResourceNotFound;
import com.customer.model.Customers;
import com.customer.service.CustomersService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomersService customersService;

	@PostMapping
	public ResponseEntity<Customers> createCustomer(@RequestBody Customers customer){
		Customers newCustomer=customersService.saveCustomer(customer);
		return ResponseEntity.status(HttpStatus.CREATED).body(newCustomer);
		
	}
	
	@GetMapping("/{customerId}")
	public ResponseEntity<Customers> getSingleCustomer(@PathVariable String customerId){
		Customers customer=customersService.getCustomer(customerId);
		if(customer==null)
			throw new ResourceNotFound("Customer not found");
		return ResponseEntity.ok(customer);
	}
	
	@GetMapping
	public ResponseEntity<List<Customers>> getAll(){
		List<Customers> allCustomers=customersService.getAllCustomers();
		return ResponseEntity.ok(allCustomers);
	}
	
	@PutMapping("/{customerId}")
	public ResponseEntity<Customers> updateCustomer(@PathVariable String customerId,@RequestBody Customers customer){
		if(customerId.equals(customer.getCustomerId())) {
			Customers newDetails=customersService.updateCustomer(customer);
			return ResponseEntity.status(HttpStatus.OK).body(newDetails);
		}
		throw new ResourceNotFound("Customer not found");
	}
	
	@DeleteMapping("/{customerId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable String customerId){
		String msg=customersService.deleteCustomer(customerId);
		if(msg.equals(""))
			throw new ResourceNotFound("Customer not found");
		return ResponseEntity.ok(msg);
	}
}
