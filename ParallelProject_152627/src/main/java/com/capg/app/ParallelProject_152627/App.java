package com.capg.app.ParallelProject_152627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.capg.bean.AccountDetails;
import com.capg.bean.CustomerDetails;
import com.capg.service.CustomerDetailsValidate;
import com.capg.service.WalletService;

public class App {
	public static void main(String[] args) {
		System.out.println("PAYMENT WALLET APPLICATION");
		System.out.println("----------------------------");
		Scanner s = new Scanner(System.in);

		mainMenu();
	}

	public static void mainMenu() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int choice = 0;

		do {
			System.out.println("\tMenu\n1.Create an Account\n2.Login into account\n3.Exit \nEnter choice:");

			try {
				choice = Integer.parseInt(br.readLine());

			} catch (NumberFormatException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
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

	public static void createAccount() {
		List<String> transId = new ArrayList<String>();
		CustomerDetails cust = new CustomerDetails();
		AccountDetails details = new AccountDetails();
		WalletService service = new WalletService();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter all your required details\n");
		try {

		
			System.out.println("Enter your full name:");
			String name = br.readLine();

			System.out.println("Enter gender:");
			String gender = br.readLine();

			System.out.println("Enter your mobile number:");
			String phoneNo = br.readLine();

			System.out.println("Enter age:");
			int age = Integer.parseInt(br.readLine());

			System.out.println("Enter email:");
			String emailId = br.readLine();

			System.out.println("Enter Account type:");
			String accType = br.readLine();

			System.out.println("Enter username:");
			String username = br.readLine();

			System.out.println("Create Password");
			String password = br.readLine();

			
			CustomerDetailsValidate validation = new CustomerDetailsValidate();

			boolean Validname = validation.validateName(name);
			boolean Validgender = validation.validateGender(gender);
			boolean Validemail = validation.validateEmailID(emailId);
			boolean ValidphoneNo = validation.validatePhoneNo(phoneNo);
			boolean Validage = validation.validateAge(age);
			boolean Validusername = validation.validateUsername(username);
			boolean Validpassword = validation.validatePassword(password);

			if (Validname && Validgender && Validemail && ValidphoneNo && Validage && Validusername && Validpassword) {

				long accNo = (long) (Math.random() * 123456789 + 1000);

				cust.setName(name);
				cust.setEmailId(emailId);
				cust.setAge(age);
				cust.setGender(gender);
				cust.setPhoneNo(phoneNo);

				details.setTransId(transId);
				details.setAccNo(accNo);
				details.setUsername(username);
				details.setPassword(password);
				details.setAccType(accType);

				details.setBalance(1000);

				if (service.createAccount(details) == 1) {
					System.out.println("Account successfully created!\n\tAccount number:" + details.getAccNo());
					mainMenu();

				} else
					System.err.println("Account creation failed");
			}else if(!Validname)
				System.err.println("Invalid Name format!");
			else if(!Validgender)
				System.err.println("Invalid gender!");
			else if(!ValidphoneNo)
				System.err.println("Invalid Mobile number format!");
			else if(!Validemail)
				System.err.println("Invalid Email format!");
			else if(!Validage)
				System.err.println("Invalid age!");
			else if(!Validusername)
				System.err.println("Invalid Username format!");
			else if(!Validpassword)
				System.err.println("Invalid Password format!");
			else
				System.out.println("Invalid details");


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void login() {
		AccountDetails details = new AccountDetails();
		WalletService service = new WalletService();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {

			System.out.println("Enter username: ");
			String username = br.readLine();
			System.out.println("Enter password:");
			String password = br.readLine();

			CustomerDetailsValidate validation = new CustomerDetailsValidate();
			if (validation.validateUsername(username) && validation.validatePassword(password)) {
				details.setUsername(username);
				details.setPassword(password);

				if (service.login(details)) {
					System.out.println("Successfully logged in !");
					extendedMenu(details);
				} else
					System.err.println("Login failed");

			} else
				System.err.println("Invalid username or password");

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static void extendedMenu(AccountDetails details) {

		WalletService service = new WalletService();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int choice = 0;
		try {

			do {
				System.out.println("Enter your choice:\n");
				System.out
						.println("1.Show the balance\n2.Deposit into account \n3.Withdraw\n4.Fund transfer\n5.Print transactions\n6.Exit");
				choice = Integer.parseInt(br.readLine());
				switch (choice) {

				case 1:
					double balance = service.showBalance();
					if (balance != -1)
						System.out.println(" Balance is"+balance);
					break;

				case 2:

					System.out.println("Enter the amount to deposit:");
					double depositAmount = Double.parseDouble(br.readLine());
					if (service.deposit(depositAmount) == 1)
						System.out.println("Amount is successfully deposited !");
					else
						System.err.println("Deposit failed");
					break;
				case 3:

					System.out.println("Enter amount to withdraw: ");
					double withdrawAmount = Double.parseDouble(br.readLine());
					if (service.withdraw(withdrawAmount) == 1)
						System.out.println("Amount is sucessfully withdrawn !");
					else
						System.err.println("Withdraw failed ! Please try again");
					break;
				case 4:

					System.out.println("Enter the account number you want to transfer amount to:");
					long toAccNo = Long.parseLong(br.readLine());
					System.out.println("Enter the amount to transfer:");
					double transferAmount = Double.parseDouble(br.readLine());
					if (service.fundTransfer(toAccNo, transferAmount) == 1)
						System.out.println("Transfer successfull !");
					else
						System.err.println("Transfer failed!Please try again");
					break;
				case 5:
					Iterator<String> it = service.printTransaction().iterator();
					while (it.hasNext()) {

						System.out.println(it.next());
					}

					break;

				case 6:
					mainMenu();
					break;

				default:
					System.out.println("Invalid choice");
					break;
				}
			} while (choice != 6);

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}


