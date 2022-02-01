package oop;
class ATM {
	private int id = 0;
	private static double balance = 0;
	private double annualInterestRate = 0;
	private java.util.Date dateCreated;
	
	ATM() {
		dateCreated = new java.util.Date();
		balance = 100;
	}
	
	public ATM(int newId, double newBalance) {
		newId = id;
		balance = newBalance;
		dateCreated = new java.util.Date();
	}
	public int getId() {
		return id;
	}
	public void setId(int a) {
		id = a;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(int b) {
		balance = b;
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
	public static double withdraw(double amount) {
		if (balance > 0) {
		}
		return balance -= amount;
	}
	public double deposit(double amount) {
		return balance += amount;
	}
}
