package oop;

public class SavingsAccount extends Account{
	private double limit = 0;
	SavingsAccount(){
		
	}
	public SavingsAccount(int id, double balance){
		super(id, balance);
	}
	@Override
	public double withdraw(double amount) {
		if(super.getBalance() > limit && amount <= super.getBalance()) {
			super.withdraw(amount);
		}
		else {
			System.out.println("Cannot overdraw account. Enter another amount.");
		}
		return amount;
	}
	@Override
	public String toString() {
		return "Savings account balance: " + balance;
	}
}