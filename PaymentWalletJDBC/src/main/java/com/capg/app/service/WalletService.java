package com.capg.app.service;

import com.capg.app.bean.AccountDetails;
import com.capg.app.dao.WalletDao;

public class WalletService implements IWalletService{
	WalletDao dao=new WalletDao();
	public int createAccount(AccountDetails details) {
		// TODO Auto-generated method stub
		return dao.createAccount(details) ;
		
	}

	public int deposit(double amount) {
		// TODO Auto-generated method stub
		return dao.deposit(amount);
	}

	public int withdraw(double amount) {
		// TODO Auto-generated method stub
		return dao.withdraw(amount);
	}

	public int fundTransfer(long toAccNo,double amount) {
		// TODO Auto-generated method stub
		return dao.fundTransfer(toAccNo, amount);
	}

	public boolean login(AccountDetails details) {
		// TODO Auto-generated method stub
		return dao.login(details);
		
	}

	public double showBalance() {
		// TODO Auto-generated method stub
		return dao.showBalance();
	}

	public void printTransaction() {
		// TODO Auto-generated method stub
		dao.printTransaction();
	}

	public void exit()
	{
		dao.exit();
	}
}
