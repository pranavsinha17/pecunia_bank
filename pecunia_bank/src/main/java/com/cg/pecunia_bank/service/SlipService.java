package com.cg.pecunia_bank.service;

import java.time.LocalDate;

public interface SlipService {
	
	String creditUsingSlip(String accountID, double amount, LocalDate transcationDate);

	String debitUsingSlip(String accountID, double amount, LocalDate transcationDate);

}
