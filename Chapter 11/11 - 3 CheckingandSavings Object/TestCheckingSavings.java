package oop;
import java.util.Scanner;
public class TestCheckingSavings {
Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
	Account account = new Account(1, 100);
	CheckingAccount checking = new CheckingAccount(2, 100);
	SavingsAccount savings = new SavingsAccount(3, 100);
	
	System.out.println(account.toString());
	checking.withdraw(601);
	savings.withdraw(101);
	
	System.out.println(checking.toString());
	System.out.println(savings.toString());
	
	System.out.println();
	
	System.out.println(account.toString());
	checking.deposit(150);
	savings.deposit(200);
	
	System.out.println(checking.toString());
	System.out.println(savings.toString());
	}
}