package com.cg.pecunia_bank.util;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.cg.pecunia_bank.dto.AccountManagement;

public class AccountManagementRepositry {
	 static ArrayList <AccountManagement> accountUsers=new ArrayList<AccountManagement>();
	public AccountManagementRepositry()
	{
	
		accountUsers.add(new AccountManagement( "328287420931","Vishal2093","PUNBO33950","current","Active",272000.00,3.00,LocalDate.of(2010,02,11)));
		accountUsers.add(new AccountManagement( "429868430211","Vishali3012","PUNBO33950","saving","Active",89000.00,3.50,LocalDate.of(2020,01,29)));
		accountUsers.add(new AccountManagement( "431032981981","Amardeep8198","PUNBO33950","current","Active",20000.00,3.50,LocalDate.of(2020,02,01)));
		accountUsers.add(new AccountManagement( "243902118471","Parnav1874","PUNBO33950","current","Active",38000.00,3.00,LocalDate.of(2020,02,03)));
		accountUsers.add(new AccountManagement( "298744987141","Satyam8714","PUNBO33950","saving","Active",5000.00,3.50,LocalDate.of(2020,02,03)));
		accountUsers.add(new AccountManagement( "398714982911","Prabhjot8291","PUNBO33950","current","Closed",0.00,0.00,LocalDate.of(2020,02,12)));
	}
	
	

	public List<AccountManagement> getAccountList() {
		// TODO Auto-generated method stub
		return accountUsers;
	}
	
	
	


}
