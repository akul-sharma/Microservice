package com.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.account.models.AccountDetails;
import com.account.service.AccountsService;
import com.account.exceptions.ResourceNotFound;


@RestController
@RequestMapping("/accounts")
public class AccountsController {

	@Autowired
	private AccountsService accountsService;
	
	@PostMapping
	public ResponseEntity<AccountDetails> createDetails(@RequestBody AccountDetails accDetails){
		AccountDetails newDetails=accountsService.saveDetails(accDetails);
		return ResponseEntity.status(HttpStatus.CREATED).body(newDetails);
	}
	
	@GetMapping("/{customerId}")
	public ResponseEntity<AccountDetails> getSingleCustomer(@PathVariable String customerId){
		AccountDetails account=accountsService.getDetails(customerId);
		if(account==null)
			throw new ResourceNotFound("Account details not found");
		return ResponseEntity.ok(account);
	}
	
	@GetMapping
	public ResponseEntity<List<AccountDetails>> getAll(){
		List<AccountDetails> allDetails=accountsService.getAllDetails();
		return ResponseEntity.ok(allDetails);
	}
	
	@DeleteMapping("/{customerId}")
	public ResponseEntity<String> deleteAccount(@PathVariable String customerId){
		String result=accountsService.deleteDetails(customerId);
		if(result.equals(""))
			throw new ResourceNotFound("Account details not found");
		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/add/{customerId}")
	public ResponseEntity<String> addMoney(@PathVariable String customerId,@RequestBody double money){
		String result=accountsService.addMoney(customerId, money);
		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/withdraw/{customerId}")
	public ResponseEntity<String> withdrawMoney(@PathVariable String customerId,@RequestBody double money){
		String result=accountsService.withdrawMoney(customerId, money);
		return ResponseEntity.ok(result);
	}
	
}
