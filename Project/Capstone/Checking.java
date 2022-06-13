package capstone;

public class Checking extends Account {
	private double limit = -500;

	// Checking account balance cannot go below -500
	Checking() {

	}

	public Checking(int id, double balance) {
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
	public boolean canWithdraw(double amount) {
		if(super.getBalance() - amount >= limit) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Your current checking account balance is: $" + balance;
	}
}
