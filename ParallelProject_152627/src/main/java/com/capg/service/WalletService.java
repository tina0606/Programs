package com.capg.service;

import java.util.List;

import com.capg.bean.AccountDetails;
import com.capg.dao.WalletDao;

public class WalletService implements IWalletService {

	WalletDao dao = new WalletDao();
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

	public List<String> printTransaction() {
		// TODO Auto-generated method stub
		return dao.printTransaction();
	}

	

//	public boolean createAccount(AccountDetails details) {
//
//		return dao.createAccount(details);
//	}
//
//	public AccountDetails showBalance(AccountDetails details) {
//
//		return dao.showBalance(details);
//	}
//
//	public AccountDetails depositBalance(double deposit, AccountDetails details) {
//
//		return dao.depositBalance(deposit, details);
//
//	}
//
//	public AccountDetails withdrawBalance(double withdraw, AccountDetails details) {
//
//		return dao.withdrawBalance(withdraw, details);
//	}
//
//	public AccountDetails transferFund(long bankaccount2, double amount, AccountDetails details) {
//
//		return dao.transferFund(bankaccount2, amount, details);
//
//	}
//
//	public AccountDetails printTransaction() {
//
//		return dao.printTransaction();
//
//	}

}
