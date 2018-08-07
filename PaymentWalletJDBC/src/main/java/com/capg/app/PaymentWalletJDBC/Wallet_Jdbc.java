package com.capg.app.PaymentWalletJDBC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.capg.app.bean.AccountDetails;
import com.capg.app.bean.CustomerDetails;
import com.capg.app.service.WalletService;
import com.capg.app.service.WalletServiceValidation;

public class Wallet_Jdbc {
	public static void main(String[] args) {
		System.out.println("PAYMENT WALLET APPLICATION");
		Scanner s = new Scanner(System.in);

		mainMenu();
	}

	public static void mainMenu() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int choice = 0;

		do {
			System.out.println("\tMenu\n1.Create an Account\n2.Login\n3.Exit\nEnter choice:");

			try {
				choice = Integer.parseInt(br.readLine());

			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			switch (choice) {
			case 1:
				createAccount();
				break;
			case 2:
				login();
				break;
			case 3:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}
		} while (choice != 3);
	}

	private static void createAccount() {

		AccountDetails details = new AccountDetails();
		CustomerDetails cust = new CustomerDetails();
		WalletServiceValidation validate = new WalletServiceValidation();
		WalletService service = new WalletService();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter all your details\n");
		try {

			System.out.println("Enter your Full name:");
			String name = br.readLine();

			System.out.println("Enter your Age:");
			int age = Integer.parseInt(br.readLine());

			System.out.println("Enter Gender:");
			String gender = br.readLine();

			System.out.println("Enter your Phone Number:");
			long phoneNo = Long.parseLong(br.readLine());

			System.out.println("Enter your Aadhar Number:");
			long aadharNo = Long.parseLong(br.readLine());

			System.out.println("Enter Username:");
			String username = br.readLine();

			System.out.println("Create a Password:");
			String password = br.readLine();

			System.out.println("Enter Account type:");
			String accType = br.readLine();

			boolean Validname = validate.validName(name);
			boolean Validgender = validate.validGender(gender);
			boolean Validage = validate.validAge(age);
			boolean Validuser = validate.validUsername(username);
			boolean Validpass = validate.validPassword(password);
			boolean ValidaadharNo = validate.validAadhar(aadharNo);
			boolean Validacctype = validate.validType(accType);

			if (Validname && Validgender && Validage && Validuser && Validpass && ValidaadharNo && Validacctype) {

				long accNo = (long) (Math.random() * 123456789 + 1000);

				cust.setName(name);
				cust.setAge(age);
				cust.setGender(gender);
				cust.setAadharNo(aadharNo);
				cust.setPhoneNo(phoneNo);

				details.setDetails(cust);
				details.setAccNo(accNo);
				details.setUsername(username);
				details.setPassword(password);
				details.setAccType(accType);
				details.setBalance(0);

				if (service.createAccount(details) == 1) {
					System.out.println(
							"Your Account has been successfully created!\n\tAccount number:" + details.getAccNo());

					mainMenu();

				} else
					System.err.println("Account creation failed.. Please try again");

			} else
				System.out.println("Invalid details");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void login() {

		AccountDetails details = new AccountDetails();
		WalletService service = new WalletService();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {

			System.out.println("Enter your username: ");
			String username = br.readLine();
			System.out.println("Enter password:");
			String password = br.readLine();

			WalletServiceValidation validate = new WalletServiceValidation();
			boolean Validuser = validate.validUsername(username);
			boolean Validpass = validate.validPassword(password);

			if (Validuser && Validpass) {
				details.setUsername(username);
				details.setPassword(password);

				if (service.login(details)) {
					System.out.println("Successfully logged in !");
					extendedMenu(details);
				} else
					System.err.println("Login failed ! Please try Again");

			} else
				System.err.println("Invalid username or password");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void extendedMenu(AccountDetails details) {

		WalletService service = new WalletService();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ch = 0;
		try {

			do {
				System.out.println("Please Enter your choice:\n");
				System.out.println(
						"1.Show balance\n2.Deposit\n3.Withdraw\n4.Fund transfer\n5.Print transactions\n6.Exit");
				ch = Integer.parseInt(br.readLine());
				switch (ch) {

				case 1:
					double balance = service.showBalance();
					if (balance != -1)
						System.out.println("The account balance is" + balance);
					break;

				case 2:

					System.out.println("Enter amount to deposit:");
					double depoAmount = Double.parseDouble(br.readLine());
					if (service.deposit(depoAmount) == 1)
						System.out.println("Amount successfully deposited !");
					else
						System.err.println("Deposit failed");
					break;
				case 3:

					System.out.println("Enter amount to withdraw: ");
					double withAmount = Double.parseDouble(br.readLine());
					if (service.withdraw(withAmount) == 1)
						System.out.println("Amount sucessfully withdrawn !");
					else
						System.err.println("Withdraw failed");
					break;
				case 4:

					System.out.println("Enter the account number to transfer amount to:");
					long toAccNo = Long.parseLong(br.readLine());
					System.out.println("Enter amount to transfer:");
					double transferAmount = Double.parseDouble(br.readLine());
					if (service.fundTransfer(toAccNo, transferAmount) == 1)
						System.out.println("Transfer is successfull...");
					else
						System.err.println("Transfer failed!Please try again");
					break;
				case 5:
					service.printTransaction();
					break;

				case 6:
					service.exit();
					mainMenu();
					break;

				default:
					System.out.println("Invalid choice");
					break;
				}
			} while (ch != 6);

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
