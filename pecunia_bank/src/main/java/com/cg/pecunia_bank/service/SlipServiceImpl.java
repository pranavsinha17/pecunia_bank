package com.cg.pecunia_bank.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

import com.cg.pecunia_bank.dao.AccountManagementDao;
import com.cg.pecunia_bank.dao.TransactionDao;
import com.cg.pecunia_bank.dto.AccountManagement;
import com.cg.pecunia_bank.exception.InsufficientBalance;
import com.cg.pecunia_bank.exception.InvalidAccountException;
import com.cg.pecunia_bank.exception.InvalidInputDataException;

public class SlipServiceImpl implements SlipService {
	
	static  List<AccountManagement> accountList=new ArrayList<AccountManagement>();
	
	 AccountManagementDao accountManagementDao=new AccountManagementDao();
	 
	                                                            // check account number contains only digit or not.
	 public boolean  stringContainsNumber(String accountID) 
	 {
		 return Pattern.compile("[0-9]").matcher(accountID).find();
	 }
	 
	 
	                                                      // check the account is exist or not in account management repositry
	 public boolean checkAccountExits( String accountID )
	 {
		 for(AccountManagement accountuser:accountList)
			{
				
				if(accountID.equals(accountuser.getAccountID()))
				{
					return true;
				}
				
			}
		return false;
	 }
	 
	 
	                                                            //get the user account object from the AccountManagementRepositry list
	 public AccountManagement getAccountObject(String accountID)
	 {
		 for(AccountManagement accountuser:accountList)
			{
				
				if(accountID.equals(accountuser.getAccountID()))
				{
					return accountuser;
				}
				
			}
		return null;
	 }
	 
	 
	                                                                     //check balance
	 public boolean checkBalance(double amount, AccountManagement user ) 
	 {
		  if(amount<=user.getAccountBalance())
		  {
			  return true;
		  }
		 return false;
	 }
	 
	                                                                        //remaning balance while debiting
	 public double debitClosingBalance(double amount,AccountManagement user)
	 {
		 return user.getAccountBalance()-amount;
	 }
	 
	 public double creditClosingBalance(double amount,AccountManagement user) //remaining balance while crediting
	 {
		 return user.getAccountBalance()+amount;
	 }
	 
	 //will validate data on diff parameters and throw suitable User define Exceptions
	 public boolean validateData(String accountID,double amount,LocalDate  transcationDate) throws InvalidInputDataException
	 {
		 
		 if(accountID.length()==12 && stringContainsNumber(accountID) ) 
			{
				if(!(amount>=100.00||amount<=200000.00))
				{
					throw new InvalidInputDataException("InvalidAccountException : "+"Invalid slip amount");
				}
				return true;
			}
		 else
		 {
			 throw new InvalidInputDataException("InvalidAccountException : "+"Invalid accountId");
		 }
		 
	 }
	 
	 
	 
	 //generate transcation id
	 public String  generatetransId()
	 {
		 Random random=new Random();
		  int transId=random.nextInt(999999);
		return ""+transId;
		 
	 }
	

	public String creditUsingSlip(String accountID, double amount, LocalDate transcationDate) {
		// TODO Auto-generated method stub
		String transid=generatetransId();
	try {
	    try {
			if(validateData( accountID, amount, transcationDate)==true)
				{

				accountList=accountManagementDao.debitUsingSlip();
				if(checkAccountExits(accountID )==false)
				{
					throw new InvalidAccountException(accountID);
				}
				else
				{
					 
					  AccountManagement user=getAccountObject(accountID);
					 //set updated balance
					  double rBalance= creditClosingBalance(amount,user);
						user.setAccountBalance(rBalance);
						 
						                                                      //add data in transaction repository
						 TransactionDao transcationdao=new TransactionDao();
						 String transID=generatetransId();
						 String transType="slip";
						 String transOption="credit";
						 String transto=accountID;
						 String transfrom="self";
						 String chequeID="null";
						 double ClosingBalance=rBalance;
						                                   //set information to transaction repo
						if( transcationdao.debitUsingSlip(transID,accountID,transType,amount,transOption,transcationDate,chequeID,transto,transfrom, ClosingBalance)==true)
						{
							System.out.println("transcation data added");
						}
						 return "Transcation Completed-->"+" Transaction id: "+transid;
				
}
			}
		} catch (InvalidInputDataException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	        } catch (InvalidAccountException e) {
				// TODO Auto-generated catch block
	        	System.out.println(e);
			}
	     
	
	
	return "Transaction Not Completed";
}
public String debitUsingSlip(String accountID, double amount, LocalDate transcationDate) {
		// TODO Auto-generated method stub

	String transid=generatetransId();
		try {
		    if(validateData( accountID, amount, transcationDate)==true)
				{

				accountList=accountManagementDao.debitUsingSlip();
				try {
				if(checkAccountExits(accountID )==false)
				{
					throw new InvalidAccountException(accountID);
				}
				else
				{
					 
					  AccountManagement user=getAccountObject(accountID);
					 
					 try {
						 
					 
					  if(checkBalance(amount,user )==false )
					  {
						  
						 //add the information to repo
						 throw new InsufficientBalance(amount);
						  
					  }
					  else
					  {
						  //set update balance
						  double rBalance= debitClosingBalance(amount,user);
							user.setAccountBalance(rBalance);
							 
							 //add data in transaction repository
							 TransactionDao transcationdao=new TransactionDao();
							 String transID=generatetransId();
							 String transType="slip";
							 String transOption="debit";
							 String transto=accountID;
							 String transfrom="self";
							 String chequeID="null";
							 double ClosingBalance=rBalance;
							 //set information to repo
							if( transcationdao.debitUsingSlip(transID,accountID,transType,amount,transOption,transcationDate,chequeID,transto,transfrom, ClosingBalance)==true)
							{
								System.out.println("transcation data added");
								
							}
							System.out.println();
							 return "Transcation Completed-->"+ "Transaction id: "+transid;
					  }
					 }catch (InsufficientBalance e)
					 {
						 System.out.println(e);
					 }
					 
					  
				}
				}catch(InvalidAccountException e)
				{
					System.out.println(e);
				}
				}
		}catch(InvalidInputDataException e)
				{
					System.out.println(e);
				}
		return "Transaction Not Completed";
		     
		
	}

	}


