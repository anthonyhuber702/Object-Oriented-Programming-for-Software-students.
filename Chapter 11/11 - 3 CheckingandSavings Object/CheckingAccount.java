package oop;

public class CheckingAccount extends Account {
	private double limit = -500;
	CheckingAccount(){
		
	} 
	public CheckingAccount(int id, double balance) {
		super(id, balance);
	}
	@Override
	public double withdraw(double amount) {
		if(super.getBalance() - amount >= limit) {
			super.withdraw(amount);
		}
		else {
			System.out.println("Overdraft limit reached. Enter another amount.");
		}
		return amount;
	}
	@Override
	public String toString() {
		return "Checking account balance: " + balance;
	}
	}
