package com.capg.app.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.capg.app.bean.AccountDetails;
import com.capg.app.util.WalletUtil;

public class WalletDao implements IWalletDao {

	static Connection connect;
	static ResultSet temp;
	static long aadharNo;
	static double balance;
	static long accNo;

	public int createAccount(AccountDetails details) {

		int a = 0, b = 0;
		try {
			connect = WalletUtil.getConnection();
			String insertCustomer = "insert into customerdetails values(?,?,?,?,?)";
			java.sql.PreparedStatement psc = connect.prepareStatement(insertCustomer);

			psc.setString(1, details.getDetails().getName());
			psc.setInt(2, details.getDetails().getAge());
			psc.setString(3, details.getDetails().getGender());
			psc.setLong(4, details.getDetails().getPhoneNo());
			psc.setLong(5, details.getDetails().getAadharNo());

			a = psc.executeUpdate();

			String insertAccount = "insert into accountdetails values(?,?,?,?,?,?)";
			java.sql.PreparedStatement psa = connect.prepareStatement(insertAccount);

			psa.setLong(1, details.getAccNo());
			psa.setString(2, details.getUsername());
			psa.setString(3, details.getPassword());
			psa.setDouble(4, details.getBalance());
			psa.setLong(5, details.getDetails().getAadharNo());
			psa.setString(6, details.getAccType());

			b = psa.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connect.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (a == 1 && b == 1) {
			return 1;
		}
		return 0;
	}

	public boolean login(AccountDetails details) {
		int a = 0;

		try {
			connect = WalletUtil.getConnection();

			String login = "select * from accountdetails where username='" + details.getUsername() + "' and password='"
					+ details.getPassword() + "'";
			java.sql.PreparedStatement sl = connect.prepareStatement(login);
			ResultSet result = sl.executeQuery();

			if (result.first())
				a = 1;
			aadharNo = result.getLong(5);
			balance = result.getLong(4);
			accNo = result.getLong(1);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (a == 1)

			return true;
		else
			return false;
	}

	public double showBalance() {

		return balance;
	}

	public int deposit(double amount) {

		try {

			String depo = "update accountdetails set balance=" + (balance + amount) + " where aadharNo=" + aadharNo;

			java.sql.PreparedStatement stmt = connect.prepareStatement(depo);
			if (stmt.executeUpdate() == 1) {

				String transaction = "Deposited:" + Double.toString(amount) + " to " + accNo;
				balance = balance + amount;
				String insertTransaction = "insert into printtransactions values(" + aadharNo + ",'" + transaction
						+ "')";
				java.sql.PreparedStatement trans = connect.prepareStatement(insertTransaction);
				trans.executeUpdate();
				return 1;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int withdraw(double amount) {
		if (balance>=amount) {
	
		try {
			String withdraw = "update accountdetails set balance=" + (balance - amount) + " where aadharNo=" + aadharNo;
			java.sql.PreparedStatement stmt = connect.prepareStatement(withdraw);
			
			if (stmt.executeUpdate() == 1) {
				String transaction = "Withdrawn:" + Double.toString(amount) + "from" + Long.toString(accNo);
				balance = balance - amount;
				String insertT = "insert into printtransactions values(" + aadharNo + ",'" + transaction + "')";
				java.sql.PreparedStatement trans = connect.prepareStatement(insertT);

				trans.executeUpdate();
				return 1;
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}}

		return 0;
	}

	public int fundTransfer(long toAccNo, double amount) {

		try {
			String receiver = "select * from accountdetails where accNo=" + toAccNo;
			java.sql.PreparedStatement trans = connect.prepareStatement(receiver);
			ResultSet temp = trans.executeQuery();

			if (temp.first()) {

				String withdraw = "update accountdetails set balance=" + (balance - amount) + " where aadharNo="
						+ aadharNo;
				balance = balance - amount;
				java.sql.PreparedStatement stmt = connect.prepareStatement(withdraw);

				if (stmt.executeUpdate() == 1) {
					String transaction = "Transfered:" + Double.toString(amount) + "to" + Long.toString(toAccNo);
					String insertT = "insert into printtransactions values(" + aadharNo + ",'" + transaction + "')";
					java.sql.PreparedStatement trans1 = connect.prepareStatement(insertT);

					trans1.executeUpdate();
				}

				double bal = temp.getDouble(4) + amount;
				String depo = "update accountdetails set balance=" + bal + " where aadharNo=" + temp.getLong(5);
				java.sql.PreparedStatement trans2 = connect.prepareStatement(depo);

				if (trans2.executeUpdate() == 1) {
					String transaction = "Received:" + Double.toString(amount) + "from" + Long.toString(accNo);
					String insertT = "insert into printtransactions values(" + temp.getLong(5) + ",'" + transaction
							+ "')";
					java.sql.PreparedStatement trans1 = connect.prepareStatement(insertT);
					trans1.executeUpdate();
					return 1;
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	public void printTransaction() {

		try {
			String print = "select TransactionInfo from printtransactions where aadharNo=" + aadharNo;
			java.sql.PreparedStatement stmt = connect.prepareStatement(print);

			ResultSet transaction = stmt.executeQuery();
			while (transaction.next()) {
				System.out.println(transaction.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void exit() {
		try {
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
