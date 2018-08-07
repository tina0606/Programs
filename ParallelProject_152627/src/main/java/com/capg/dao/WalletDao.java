package com.capg.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.capg.bean.AccountDetails;

public class WalletDao implements IWalletDao {

	long transId;
	static AccountDetails acc = new AccountDetails();
	static List<AccountDetails> list = new ArrayList<AccountDetails>();

	public int createAccount(AccountDetails details) {
		if (list.add(details)) {
			acc = details;
			return 1;
		} else
			return 0;
	}

	public boolean login(AccountDetails details) {

		Iterator<AccountDetails> iterator = list.iterator();
		while (iterator.hasNext()) {
			AccountDetails det = iterator.next();
			if (details.getUsername().equals(det.getUsername()) && details.getPassword().equals(det.getPassword())) {
				acc = det;
				return true;
			}
		}
		return false;
	}

	public double showBalance() {

		Iterator<AccountDetails> iterator = list.iterator();
		while (iterator.hasNext()) {
			AccountDetails det = iterator.next();
			if (acc.getUsername().equals(det.getUsername())) {
				double balance = det.getBalance();
				return balance;
			}
		}
		return -1;
	}

	public int deposit(double amount) {

		Iterator<AccountDetails> iterator = list.iterator();
		while (iterator.hasNext()) {
			AccountDetails det = iterator.next();
			if (acc.getUsername().equals(det.getUsername())) {
				det.setBalance(det.getBalance() + amount);
				transId = (long) (Math.random() * 12345 + 678);
				String s = Long.toString(transId) + ":\tDeposited " + Double.toString(amount) + " to "
						+ Long.toString(det.getAccNo()) + " Balance: " + det.getBalance();
				det.getTransId().add(s);
				return 1;
			}
		}
		return 0;
	}

	public int withdraw(double amount) {

		if (acc.getBalance() > amount) {
			Iterator<AccountDetails> iterator = list.iterator();
			while (iterator.hasNext()) {
				AccountDetails det = iterator.next();
				if (acc.getUsername().equals(det.getUsername())) {
					det.setBalance(det.getBalance() - amount);
					transId = (long) (Math.random() * 10000 + 999);
					String s = Long.toString(transId) + ":\tWithdrew " + Double.toString(amount) + " from "
							+ Long.toString(det.getAccNo()) + " Balance: " + det.getBalance();
					det.getTransId().add(s);
					return 1;
				}

			}
		}
		return 0;
	}

	public int fundTransfer(long toAccNo, double amount) {

		Iterator<AccountDetails> iterator = list.iterator();
		Iterator<AccountDetails> iterator1 = list.iterator();
		while (iterator.hasNext()) {

			AccountDetails det = iterator.next();
			if (acc.getUsername().equals(det.getUsername())) {

				transId = (long) (Math.random() * 12345 + 234);
				det.setBalance(det.getBalance() - amount);

				while (iterator1.hasNext()) {

					AccountDetails itDetails1 = iterator1.next();
					if (itDetails1.getAccNo() == toAccNo) {

						itDetails1.setBalance(itDetails1.getBalance() + amount);
						String s1 = Long.toString(transId) + "Recieved :" + Double.toString(amount) + " from "
								+ Long.toString(det.getAccNo()) + "\t Balance :" + itDetails1.getBalance();
						itDetails1.getTransId().add(s1);
					}
				}
				String s = Long.toString(transId) + ":\tTransfered " + Double.toString(amount) + " to "
						+ Long.toString(toAccNo) + " from " + Long.toString(det.getAccNo()) + " Balance :"
						+ det.getBalance();
				det.getTransId().add(s);
				return 1;
			}
		}
		return 0;
	}

	public List<String> printTransaction() {

		Iterator<AccountDetails> iterator = list.iterator();
		while (iterator.hasNext()) {
			AccountDetails det = iterator.next();
			if (acc.getUsername().equals(det.getUsername())) {
				return det.getTransId();
			}
		}
		return null;
	}

}
