package com.cg.pecunia_bank.exception;

@SuppressWarnings("serial")
public class InvalidAccountException extends Exception {

	String accountID;
	public InvalidAccountException(String accountID)
	{
		this.accountID=accountID;
	}
	@Override
	public String toString()
	{
		return "InvalidAccountException:"+"Account Does Not Exist ||  A/c No: "+accountID;
	}

}
