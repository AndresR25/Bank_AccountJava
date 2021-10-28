import java.util.Random;
public class BankAccount {

    public static void main(String[] args) {
		BankAccount account = new BankAccount();
		account.depositMoney(50.1, "Check");
		account.depositMoney(10, "savings");
		account.Balance();

		System.out.println(BankAccount.Holdings);

		account.withdrawMoney(10, "Check");
		account.withdrawMoney(9, "savings");
		account.Balance();

		System.out.println(BankAccount.Holdings);
	}
    private double CheckBalance;
	private double savingsBalance;

	public static int accounts = 0;
	public static double Holdings = 0;

    public BankAccount() {
		BankAccount.accounts += 1;
		this.CheckBalance = 0;
		this.savingsBalance = 0;
		
	}

    public double getCheckBalance() {
		return this.CheckBalance;
	}

	public double getSavingsBalance() {
		return this.savingsBalance;
	}

    public void depositMoney(double amount, String account) {
		if(account.equals("savings"))
			this.savingsBalance += amount;
		else if(account.equals("Check"))
			this.CheckBalance += amount;
		BankAccount.Holdings += amount;
	}


	public void withdrawMoney(double amount, String account) {
		boolean exit = false;
		if(account.equals("savings")) {
			
			if(this.savingsBalance - amount >= 0) {
				exit = true;
				this.savingsBalance -= amount;
			}
		}
		else if(account.equals("Check")) {
			
			if(this.CheckBalance - amount >= 0) {
				exit = true;
				this.CheckBalance -= amount;
			}
		}
		if(exit) {
			BankAccount.Holdings -= amount;
		}
	}

	public void Balance() {
		System.out.println(String.format("Savings: %.2f, Check: %.2f", this.savingsBalance, this.CheckBalance));
	}

	
}