package capstone;

public class Savings extends Account {
	private double limit = 0;

	// Savings account balance cannot go below 0
	Savings() {

	}

	public Savings(int id, double balance) {
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
	public boolean canWithdraw(double amount) {
		if(super.getBalance() > limit && amount <= super.getBalance()) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Your current savings account balance is: $" + balance;
	}
}
