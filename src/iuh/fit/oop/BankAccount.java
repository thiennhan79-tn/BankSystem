package iuh.fit.oop;
/*
 * @author:  Pham Cao Thien Nhan
 * @created: 19-Sep-2025
 */


public class BankAccount {
	private String accountNumber;
	private String ownerName;
	private double balance;
	
	
	public BankAccount() {
		this("0000-0000-0000","No name",0.0);
	}



	public BankAccount(String accountNumber,String ownerName , double balance) {
		
		setAccountNumber(accountNumber);
		setOwnerName(ownerName);
		setBalance(balance);
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		if (balance < 0) {
            throw new IllegalArgumentException("Balance must be greater than or equal to 0");
        }
		this.balance = balance;
	}
	
	
	public String getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(String accountNumber) {
		if(accountNumber == null || accountNumber.isEmpty()) {
			throw new IllegalArgumentException("The account number must not be null");
		}
		
		this.accountNumber = accountNumber;
	}


	public String getOwnerName() {
		return ownerName;
	}



	public void setOwnerName(String ownerName) {
		if(ownerName == null || ownerName.isEmpty()) {
			throw new IllegalArgumentException("The owner name must not be null");
		}
		
		this.ownerName = ownerName;
	}

	
	public void deposit(double amount) {
		if(amount <= 0) {
			throw new IllegalArgumentException("Amount must be greater than 0");
		}
			balance +=amount;
	}
	
	
	
	public void withdraw(double amount) {
		if(amount <= 0 || amount > balance ) {
			throw new IllegalArgumentException("Amount must be greater than 0 and less than or equal to balance") ;
		}
			balance -=amount;
	}
	
	public void transfer(BankAccount other, double amount) {
		if(other == null || amount <= 0 || amount > balance) {
			System.out.println("Transfer failed!");
		}
		this.withdraw(amount);
		other.deposit(amount);
		System.out.println("Transfer successful!");	
	}


	
	
	public String toString() {
		return String.format("Account Number: %s, Owner Name: %s, Balance: %s",
				accountNumber,ownerName, balance);
	}
	
	
	
	
	
	
}
