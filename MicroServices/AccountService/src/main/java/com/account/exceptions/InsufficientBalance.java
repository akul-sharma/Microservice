package com.account.exceptions;

@SuppressWarnings("serial")
public class InsufficientBalance extends RuntimeException{

	public InsufficientBalance(String message) {
		super(message);
		
	}
	
}
