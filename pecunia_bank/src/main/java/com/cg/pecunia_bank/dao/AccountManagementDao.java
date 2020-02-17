package com.cg.pecunia_bank.dao;

import java.util.ArrayList;
import java.util.List;

import com.cg.pecunia_bank.dto.AccountManagement;
import com.cg.pecunia_bank.util.AccountManagementRepositry;

public class AccountManagementDao {
  static List<AccountManagement> accountList=new ArrayList<AccountManagement>();
	AccountManagementRepositry accontManagementRepositry=new AccountManagementRepositry();
	public List<AccountManagement> debitUsingSlip()
	{
		accountList=accontManagementRepositry.getAccountList();         //getting data from repository
		return accountList ;
		
	}

}