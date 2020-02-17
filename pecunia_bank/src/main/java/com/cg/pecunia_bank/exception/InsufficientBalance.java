package com.cg.pecunia_bank.exception;

@SuppressWarnings("serial")
public class InsufficientBalance extends Exception {

	double amount;
	public InsufficientBalance(double amount)
	{
		this.amount=amount;
	}
	@Override
	public String toString()                  
	{
		return "InsufficientBalance:"+"Account Balance is lower than Requested Amount-> "+amount;
	}
	
}
