package oop;
import java.util.Scanner;
public class testATM {
	ATM[] account = new ATM[10];
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ATM[] account = new ATM[10];
		for (int i = 0; i < account.length; i++) {
			account[i] = new ATM();
			account[i].setId(i);
			account[i].setBalance(100);
		}
		System.out.print("Enter an ID: ");
		int id;
		while(true) {
		id = input.nextInt();
		if (id <= 9 && id >= 0 && id == account[id].getId()) {
				while(true) {	
					System.out.println("Main Menu");
					System.out.println("1: Check Balance");
					System.out.println("2: Withdraw");
					System.out.println("3: Deposit");
					System.out.println("4: Exit");
			    int user = input.nextInt();
				String option = "";
				double amount = 0.0;
					if (user == 1) {
						option = "Check Balance";
						System.out.println("Your balance is: $" + account[id].getBalance());
					}
					else if (user == 2) {
						option = "Withdraw";
						System.out.print("Enter amount to withdraw: $");
						amount =input.nextDouble();
						account[id].withdraw(amount);
					}
					else if (user == 3) {
						option = "Deposit";
						System.out.print("Enter amount to deposit: $");
						amount = input.nextDouble();
						account[id].deposit(amount);
					}
					else if (user == 4) {
						break;
					}
				}
				
			}
		else 
			System.out.println("Invalid ID. Try again.");
		System.out.println("Enter an ID: ");
	  }
	}
}
