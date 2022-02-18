package project;

import java.util.Scanner;

public class TestATMProject {
	ATMProject[] account = new ATMProject[10];
	static int bills;
	static int set;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ATMProject[] account = new ATMProject[10];
		CheckingAccount checking = new CheckingAccount();
		SavingsAccount savings = new SavingsAccount();
		for (int i = 0; i < account.length; i++) {
			account[i] = new ATMProject();
			account[i].setId(i);
			account[i].setBalance(100);
		}
		// ID must be between 0 and 9
		System.out.print("Enter your ID\n[1][2][3]\n[4][5][6]\n[7][8][9]\n < [0] >\n");
		int id;
		while (true) {
			id = input.nextInt();
			if (id <= 9 && id >= 0 && id == account[id].getId()) {
				// Choosing a checking or savings account creates 2 different accounts with 2
				// separate balances
				System.out.println(">[1] Checking Account\n>[2] Savings Account");
				int userAcc = input.nextInt();
				while (true) {
					System.out.println("Main Menu\n>[1] Check Balance\n>[2] Withdraw\n>[3] Deposit\n>[4] Exit");
					int user = input.nextInt();
					String option = "";
					double amount = 0.0;
					if (user == 1 && userAcc == 1) {
						option = "Check Balance";
						System.out.println(checking.toString());
					} else if (user == 1 && userAcc == 2) {
						System.out.println(savings.toString());
					}

					else if (user == 2 && userAcc == 1 || user == 2 && userAcc == 2) {
						option = "Withdraw";
						System.out.print(
								"Enter amount to withdraw:\n>[1] $20\n>[2] $50\n>[3] $80\n>[4] $100\n>[5] Other\n>[0] Back\n");
						bills = input.nextInt();

						switch (bills) {
						case 1:
							set = 20;
							break;
						case 2:
							set = 50;
							break;
						case 3:
							set = 80;
							break;
						case 4:
							set = 100;

						}
						while (bills != 0) {
							if (bills == 5) {
								System.out.print("Enter amount you wish to withdraw: $");
								amount = input.nextDouble();
								System.out.println("Are you sure you want to withdraw $" + amount
										+ " from your account? \n>[1] YES\n>[2] NO");
								int choice = input.nextInt();
								if (choice == 1 && userAcc == 1) {
									checking.withdraw(amount);
									break;
								} else if (choice == 1 && userAcc == 2) {
									savings.withdraw(amount);
									break;
								} else if (choice == 2) {
									break;
								}
							} else {
								System.out.println("Are you sure you want to withdraw $" + set
										+ " from your account? \n>[1] YES\n>[2] NO");
								int choice = input.nextInt();
								if (choice == 1 && userAcc == 1) {
									checking.withdraw(set);
									break;
								} else if (choice == 1 && userAcc == 2) {
									savings.withdraw(set);
									break;
								} else if (choice == 2) {
									break;
								}
							}
						}
					} else if (user == 3 && userAcc == 1 || user == 3 && userAcc == 2) {
						option = "Deposit";
						System.out.print(
								"Enter amount to deposit:\n>[1] $20\n>[2] $50\n>[3] $80\n>[4] $100\n>[5] Other\n>[0] Back\n");
						bills = input.nextInt();

						switch (bills) {
						case 1:
							set = 20;
							break;
						case 2:
							set = 50;
							break;
						case 3:
							set = 80;
							break;
						case 4:
							set = 100;

						}
						while (bills != 0) {
							if (bills == 5) {
								System.out.print("Enter amount you wish to deposit: $");
								amount = input.nextDouble();
								System.out.println("Are you sure you want to deposit $" + amount
										+ " into your account? \n>[1] YES\n>[2] NO");
								int choice = input.nextInt();
								if (choice == 1 && userAcc == 1) {
									checking.deposit(amount);
									break;
								} else if (choice == 1 && userAcc == 2) {
									savings.deposit(amount);
									break;
								} else if (choice == 2) {
									break;
								}
							} else {
								System.out.println("Are you sure you want to deposit $" + set
										+ " into your account? \n>[1] YES\n>[2] NO");
								int choice = input.nextInt();
								if (choice == 1 && userAcc == 1) {
									checking.deposit(set);
									break;
								} else if (choice == 1 && userAcc == 2) {
									savings.deposit(set);
									break;
								} else if (choice == 2) {
									break;
								}
							}
						}
					} else if (user == 4) {
						System.out.println("Thank you for banking with us. Come again soon! :)");
						break;
					}
				}
			} else
				System.out.println("Invalid ID. Try again.");
			System.out.print("Enter your ID\n[1][2][3]\n[4][5][6]\n[7][8][9]\n < [0] >\n");
		}
	}
}
