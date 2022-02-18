package project;
public class SavingsAccount extends ATMProject {
	private double limit = 0;

	// Savings account balance cannot go below 0
	SavingsAccount() {

	}

	public SavingsAccount(int id, double balance) {
		super(id, balance);
	}

	@Override
	public double withdraw(double amount) {
		if (super.getBalance() > limit && amount <= super.getBalance()) {
			super.withdraw(amount);
		} else {
			System.out.println("Cannot overdraw account. Choose a different option.");
		}
		return amount;
	}

	@Override
	public String toString() {
		return "Your current savings account balance is: $" + balance;
	}
}