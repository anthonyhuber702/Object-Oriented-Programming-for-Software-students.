package oop;

class Account {
	private int id = 0;
	private double balance = 0;
	private double annualInterestRate = 0;
	private java.util.Date dateCreated;
	
	public Account() {
		dateCreated = new java.util.Date();
	}
	
	public Account(int newId, double newBalance, double newInterestRate) {
		id = newId;
		balance = newBalance;
		annualInterestRate = newInterestRate;
		dateCreated = new java.util.Date();
	}
	public int getId() {
		return id;
	}
	public double getBalance() {
		return balance;
	}
	public double getAnnualInterestRate() {
		return annualInterestRate / 100;
	}
	public java.util.Date getDateCreated(){
		return dateCreated;
	}
	public double getMonthlyInterestRate() {
		return annualInterestRate / 12 / 100;
	}
	public double getMonthlyInterest() {
		return balance * (annualInterestRate / 12 / 100);
	}
	public double withdraw(double amount) {
		if (balance > 0) {
		}
		return balance -= amount;
	}
	public double deposit(double amount) {
		return balance += amount;
	}
}
