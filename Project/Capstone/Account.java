package capstone;

class Account {
protected int id = 0;
protected double balance = 0;
protected java.util.Date dateCreated;

Account() {
	dateCreated = new java.util.Date();
	balance = 100;
}

public Account(int newId, double newBalance) {
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

public java.util.Date getDateCreated() {
	return dateCreated;
}

public double withdraw(double amount) {
	if (balance > 0) {
	}
	return balance -= amount;
}

public double deposit(double amount) {
	return balance += amount;
}

public String toString() {
	return "Account accessed on " + dateCreated;
	}
}
