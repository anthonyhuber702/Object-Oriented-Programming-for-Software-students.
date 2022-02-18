package project;

public class CheckingAccount extends ATMProject {
	private double limit = -500;

	// Checking account balance cannot go below -500
	CheckingAccount() {

	}

	public CheckingAccount(int id, double balance) {
		super(id, balance);
	}

	@Override
	public double withdraw(double amount) {
		if (super.getBalance() - amount >= limit) {
			super.withdraw(amount);
		} else {
			System.out.println("Overdraft limit reached. Choose a different option.");
		}
		return amount;
	}

	@Override
	public String toString() {
		return "Your current checking account balance is: $" + balance;
	}
}
