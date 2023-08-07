package com.customer.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.model.Customers;

public interface CustomersRepo extends JpaRepository<Customers,String>{

}
