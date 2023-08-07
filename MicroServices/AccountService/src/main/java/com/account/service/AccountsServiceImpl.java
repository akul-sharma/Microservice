package com.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.exceptions.InsufficientBalance;
import com.account.exceptions.ResourceNotFound;
import com.account.models.AccountDetails;
import com.account.models.Customers;
import com.account.repo.AccountsRepo;

@Service
public class AccountsServiceImpl implements AccountsService{
	
	@Autowired
	AccountsRepo accountsRepo;
	
	@Autowired
	private CustomerService customerService;

	@Override
	public AccountDetails saveDetails(AccountDetails accDetails) {
		return accountsRepo.save(accDetails);
	}

	@Override
	public AccountDetails getDetails(String customerId) {
		AccountDetails account= accountsRepo.findById(customerId).orElse(null);
		if(account==null)
			throw new ResourceNotFound("Account details not found");
		Customers customer=customerService.getCustomerDetails(customerId);
		if(customer!=null)
		  account.setCustomerDetails(customer);
		return account;
	}

	@Override
	public List<AccountDetails> getAllDetails() {
		List<AccountDetails> accounts=accountsRepo.findAll();
		for(AccountDetails account: accounts) {
			String customerId=account.getCustomerId();
			Customers customer=customerService.getCustomerDetails(customerId);
			account.setCustomerDetails(customer);
		}
		return accounts;
	}

	@Override
	public String deleteDetails(String customerId) {
		AccountDetails account=accountsRepo.findById(customerId).orElse(null);
		if(account!=null) {
		   accountsRepo.delete(account);
		   return "Deleted Successfully !!";
		}
		return "";
	}

	@Override
	public String addMoney(String customerId, double money) {
		Customers customer=customerService.getCustomerDetails(customerId);
		if(customer!=null) {
			AccountDetails account=accountsRepo.findById(customerId).orElse(null);
			double newBalance=account.getBalance()+money;
			account.setBalance(newBalance);
			accountsRepo.save(account);
			return "Amount Added Successfully !!";
		}
		throw new ResourceNotFound("Customer not found");
	}

	@Override
	public String withdrawMoney(String customerId, double money) {
		Customers customer=customerService.getCustomerDetails(customerId);
		if(customer!=null) {
			AccountDetails account=accountsRepo.findById(customerId).orElse(null);
			double currentBalance=account.getBalance();
			if(currentBalance-money<0) {
				throw new InsufficientBalance("Balance is low");
			}
			account.setBalance(currentBalance-money);
			accountsRepo.save(account);
			return "Amount Withdrawn Successfully !!";
		}
		throw new ResourceNotFound("Customer not found");
	}

	

}
