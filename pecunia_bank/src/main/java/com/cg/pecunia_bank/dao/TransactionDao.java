package com.cg.pecunia_bank.dao;

import java.time.LocalDate;

import com.cg.pecunia_bank.dto.Transaction;
import com.cg.pecunia_bank.util.TransactionRepositry;

public class TransactionDao {
	public boolean debitUsingSlip(String transID, String accountID, String transType, double amount, String transOption, LocalDate transcationDate, String chequeID, String transto, String transfrom, double closingBalance)
	{
		Transaction transcation =new Transaction(transID,accountID,transType,amount,transOption,transcationDate,chequeID,transto,transfrom,closingBalance);
		@SuppressWarnings("unused")
		TransactionRepositry transcationRepositry =new TransactionRepositry (transcation);   //adding data to repository
		return true;
	}

}
