package com.cg.pecunia_bank.dto;
import java.time.LocalDate;

public class Transaction {
	String transId;
	String trasAccountId;
	String transType;
	double transAmount;
	String transOption;
	LocalDate transDate;
	String transChequeID;
	String transFrom;
	String transTo;
	double transClosingBalance;
	
    /*Constructor*/
	public Transaction(String transId, String trasAccountId, String transType, double transAmount, String transOption,
			LocalDate transcationDate, String transChequeID, String transFrom, String transTo, double transClosingBalance) {
		super();
		this.transId = transId;
		this.trasAccountId = trasAccountId;
		this.transType = transType;
		this.transAmount = transAmount;
		this.transOption = transOption;
		this.transDate = transcationDate;
		this.transChequeID = transChequeID;
		this.transFrom = transFrom;
		this.transTo = transTo;
		this.transClosingBalance = transClosingBalance;
	}
	
	
	public String getTrasAccountId() {
		return trasAccountId;
	}

	public void setTrasAccountId(String trasAccountId) {
		this.trasAccountId = trasAccountId;
	}

	public double getTransClosingBalance() {
		return transClosingBalance;
	}

	public void setTransClosingBalance(double transClosingBalance) {
		this.transClosingBalance = transClosingBalance;
	}

	
}
