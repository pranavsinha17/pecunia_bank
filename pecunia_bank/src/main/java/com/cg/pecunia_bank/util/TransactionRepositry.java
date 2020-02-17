package com.cg.pecunia_bank.util;
import java.util.ArrayList;

import com.cg.pecunia_bank.dto.Transaction;

public class TransactionRepositry {
	static ArrayList <Transaction> transcationData=new ArrayList <Transaction>();

	public static ArrayList<Transaction> getSlipdata() {
		return transcationData;
	}

	public TransactionRepositry(Transaction transcation) {
		transcationData.add(transcation);
	}

	
}
