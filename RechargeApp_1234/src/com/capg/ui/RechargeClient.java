package com.capg.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.capg.bean.RechargeDetails;
import com.capg.exception.NoTransactionFoundException;
import com.capg.service.RechargeDataValidate;
import com.capg.service.RechargeService;

public class RechargeClient
{ 
	static boolean b;
 
public static void main(String[] args)
{
	int choice=0;
	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
 System.out.println("Welcome to Services");
	  try
		{
			do {
				
				
				System.out.println("Enter Choice: \n 1.Recharge \n 2.Display \n 3.update  \n 4.remove \n 5.display All  ");
				
				choice=Integer.parseInt(br.readLine());
				switch(choice)
				{	
				case 1:
					recharge();
					break;
				case 2:
					display();
					break;
				case 3:
					update();
					break;
				case 4:
					remove();
					break;
				case 5:
					displayAll();
					break;
				case 6:
				System.exit(0);;
				break;
				
				default:
					System.out.println("Invalid choice");
					break;
			}
		}while(choice!=6);
		
		}
		
		catch(NumberFormatException e) {
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		
		}	}	
public static void recharge() 
{
	long transactionId=0;

	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	
	RechargeDataValidate validate=new RechargeDataValidate();
	RechargeService service=new RechargeService();
	RechargeDetails recharge=new RechargeDetails();
	
	
	try {
		System.out.println("Enter Operator(Airtel/DishTV/Reliance/TataSky)");
		String dthOperator=br.readLine();
		
		System.out.println("Enter Consumer NO");
		String ConsumerNo=br.readLine();
		
		System.out.println("Enter Recharge plan(Monthly/Quarterly/Half yearly/Anuual");
		String rechargePlan=br.readLine();
		
		System.out.println("Enter Amount (100 to 9999)");
		String amount=br.readLine();
		
		transactionId= (long) (Math.random() *12345+9999);
		 
		boolean isValidOperator= validate.validatedthOperator(dthOperator); 
		boolean isValidConsumerNo= validate.validateConsumerNo(ConsumerNo);
		boolean isValidrechargePlan=validate.validatePlan(rechargePlan);
		boolean isValidamount=validate.validateAmount(amount);
	   
		recharge.setDthOperator(dthOperator);
		recharge.setConsumerNo(Integer.parseInt(ConsumerNo));
		recharge.setRechargePlan(rechargePlan);
		recharge.setTransactionId(transactionId);
		recharge.setAmount(Integer.parseInt(amount));
			
			 
		if(isValidOperator && isValidConsumerNo && isValidrechargePlan && isValidamount)
		{
					
			b=service.addRechargeDetails(recharge);
		}	
		else
		{ 
			System.out.println("Invalid Data");
		}
	} 
			catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		if(b)
		{
			System.out.println("Recharge Succesful TransactioniId "+transactionId);
		}else
		{
			try {
				throw new NoTransactionFoundException();
			} catch (NoTransactionFoundException e) {
				// TODO Auto-generated catch block
				System.err.println("Transaction Failure");
			}
		}}
public static void update()
{
	RechargeService service=new RechargeService();
	RechargeDetails newR=new RechargeDetails();
	
	System.out.println("enter transaction id");
	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	try {
		long t=Long.parseLong(br.readLine());
		System.out.println("Enter new dthOperator:");
		String newOperator=br.readLine();
		System.out.println("Enter new ConsumerNo:");
		int newConsumerNo=Integer.parseInt(br.readLine());
		System.out.println("Enter new rechargePlan:");
		String newRechargePlan=br.readLine();
		System.out.println("Enter new amount:");
		int newAmount=Integer.parseInt(br.readLine());
		
		newR.setTransactionId(t);
		newR.setDthOperator(newOperator);
		newR.setConsumerNo(newConsumerNo);
		newR.setRechargePlan(newRechargePlan);
		newR.setAmount(newAmount);
		
		if(service.updateRechargeDetails(newR))
			System.out.println("Details Updated");
		else
			System.out.println("Details not updated");
	}catch(NumberFormatException e) {
		e.printStackTrace();
	}
	catch(IOException e)
	{
		e.printStackTrace();
	
	}		
}
public static void display()
{
	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	RechargeService service=new RechargeService();
	 
	System.out.println("Enter Transaction id:");
	long t;
	try {
		t=Long.parseLong(br.readLine());
		System.out.println(service.displayRechargeDetails(t));
	}
	
	catch(NumberFormatException e) {
		e.printStackTrace();
	}
	catch(IOException e)
	{
		e.printStackTrace();
	
	}		}	
		
  public static void displayAll()
  {
	  RechargeService service=new RechargeService();
	  System.out.println(service.displayAllRechargeDetails().toString());
	 
  }
	public static void remove()
	{
		RechargeService service=new RechargeService();
		RechargeDetails newR=new RechargeDetails();
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));	
		try
		{
			System.out.println("Enter transaction id:");
			long t=Long.parseLong(br.readLine());
			if(service.removeRechargeDetails(t))
				System.out.println("Details Removed");
			else
				System.out.println("Details failed to remove");
			
			
			}catch(NumberFormatException e) {
				e.printStackTrace();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			
			}		
		}	
		
}	
		
			

	
		
		

			
	
