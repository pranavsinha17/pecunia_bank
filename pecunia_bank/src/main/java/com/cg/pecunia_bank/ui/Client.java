package com.cg.pecunia_bank.ui;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import com.cg.pecunia_bank.dto.Transaction;
import com.cg.pecunia_bank.service.SlipService;
import com.cg.pecunia_bank.service.SlipServiceImpl;
import com.cg.pecunia_bank.util.TransactionRepositry;
public class Client {
	
	public static void main(String ar[])
	{
		String employeeID;
		String password;
		Scanner sc=new Scanner(System.in);
		SlipService slipservice=new SlipServiceImpl();
		                                                   //employeeid=pranavPUNB and password=PUNBpranav
		                                                    //are given to the employee by administration.
		System.out.println("Enter EmployeeID: ");
		employeeID=sc.next();
		System.out.println("Enter Password: ");
		password=sc.next();
		if(employeeID.equals("pranavPUNB") && password.equals("PUNBpranav"))       //Employee Login
		{
			int option;
			do
			{
		        System.out.println("1. debit  using slip");
				System.out.println("2. credit using slip");
				System.out.println("3. exit the program");
				System.out.println("enter your choice : ");
				option=sc.nextInt();
			switch(option)
			{
			case 1:
			{
				System.out.println("enter accountID : ");             //beneficiary account no
				String accountID=sc.next();
				System.out.println("enter amount : ");                //amount to debit
				double amount=sc.nextDouble(); 
				LocalDate transcationDate =  LocalDate.now();
				System.out.println(slipservice.debitUsingSlip(accountID,amount,transcationDate));  
				ArrayList<Transaction> ar1=new ArrayList<Transaction>();
				ar1=TransactionRepositry.getSlipdata();
				for(Transaction t : ar1)
				{
					System.out.println(t.getTransClosingBalance());            // this loop is basically for verifying whether the data is 
					                                                           // being manipulated or not.
				}
			}
				break;
			case 2:
			{
				System.out.println("enter accountID : ");                     //beneficiary account no
				String accountID=sc.next();
				System.out.println("enter amount : ");                       
				double amount=sc.nextDouble();                                 //amount to credit
				LocalDate transcationDate=LocalDate.now();
				System.out.println(slipservice.creditUsingSlip(accountID,  amount,  transcationDate));
				ArrayList<Transaction> ar1=new ArrayList<Transaction>();
				ar1=TransactionRepositry.getSlipdata();
				for(Transaction t : ar1)
				{
					System.out.println(t.getTransClosingBalance());
				}
				
			}
				break;
			case 3: System.out.println("exiting");
			break;
				
			default:
			{
				System.out.println("Invalid option");
			}
				break;
			}
			}while(option!=3);                               //stops if 3 entered.
		}
		else
		{
			System.out.println("Your Id or password are invalid ");
		}
		sc.close();
	}
		
}
