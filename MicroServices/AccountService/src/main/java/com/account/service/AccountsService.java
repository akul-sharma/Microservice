package com.account.service;

import java.util.List;

import com.account.models.AccountDetails;

public interface AccountsService {

	AccountDetails saveDetails(AccountDetails accDetails);
	
	AccountDetails getDetails(String customerId);
	
	List<AccountDetails> getAllDetails();
	
	String deleteDetails(String customerId);
	
	String addMoney(String customerId, double money);
	
	String withdrawMoney(String customerId, double money);
	
}
