package org.jsp.task;

import java.util.Scanner;

public class BankingApplication {
	//Simple Banking Application
	static String accHolderName;
	static long mobileNo;
	static String address;
	static double balance;
	static boolean accountCreated = false; //check account is created or not 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int in = 0;
		
		do {
			System.out.println("1. Create Account\n2. Deposit Money\n3. Withdraw Money\n4. check balance\n5. Exit");
			in = sc.nextInt();
			switch (in) {
			case 1: {
	                 createAcc(sc);
			}
			break;
			case 2:{
				    if(accountCreated) {
				    	depositMoney(sc);
				    }else {
				    	System.out.println("Please create an account first");
				    }
			}
			break;
			case 3:{
				if(accountCreated) {
					withdrawMoney(sc);
			    }else {
			    	System.out.println("Please create an account first");
			    }
				    
			}
			break;
			case 4:{
				if(accountCreated) {
					 checkBalance();
			    }else {
			    	System.out.println("Please create an account first");
			    }  
				   
			}
	        break;
			case 5:{
				    System.out.println("Thank You !! Visit again");
			}
			break;
			default:
				System.out.println("Enter valid Input");
			}


		}while(in != 5);
		}

    //create account
	public static void createAcc(Scanner sc) {
		sc.nextLine();
		System.out.println("Enter your Name");
		accHolderName = sc.nextLine();
		System.out.println("Enter Mobile Number");
		mobileNo = sc.nextLong();
		sc.nextLine();
		System.out.println("Enter your Address");
		address = sc.nextLine();
		balance = 0;
		accountCreated = true;
		System.out.println("Account Created Successfully !!");
	}
	//deposit money
	public static void depositMoney(Scanner sc) {
		System.out.println("Enter the amount to Deposit");
		double damount = sc.nextDouble();
		if(damount>0) {
			balance += damount;
			System.out.println("Amount Deposited Successfully "+damount);
		}else {
			System.out.println("Invalid Input ,please Enter Positive value");
		}
	}
	//withdraw money
	public static void withdrawMoney(Scanner sc) {
		System.out.println("Enter the Amount to Withdraw");
		double wamount = sc.nextDouble();
		if(wamount>balance) {
			System.out.println("Insufficient Balance ");
		}else if(wamount>0 && balance > wamount) {
			balance -= wamount ;
			System.out.println("withdraw Amount successfully "+wamount);
		}else {
			System.out.println("Invalid input , please Enter a positive value.");
		}
		
	}
	//check balance
	public static void checkBalance() {
		System.out.println("Current Balance : "+balance);
	}
}