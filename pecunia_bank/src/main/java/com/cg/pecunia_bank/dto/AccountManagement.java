package com.cg.pecunia_bank.dto;
import java.time.LocalDate;

public class AccountManagement {
	private String accountID;
	private double accountBalance;
	
	     /*Constructor*/
	public AccountManagement(String accountID, String accountHolderID, String accountBranchID, String accountType,
			String accountStatus,double accountBalance, double accountInterest, LocalDate  lastUpadte) {
		//super();
		this.accountID = accountID;
	
		this.accountBalance = accountBalance;
	}

	public String getAccountID() {
		return accountID;
	}


	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	
	

}
