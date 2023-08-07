package com.account.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.account.models.AccountDetails;

public interface AccountsRepo extends JpaRepository<AccountDetails, String>{

}
