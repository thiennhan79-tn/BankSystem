package iuh.fit.oop;

import java.util.ArrayList;

public class Bank {
	private String name;
	private ArrayList<BankAccount> accounts;
	private int numberOfAccounts;
		
	
	
	public Bank() {
		this("IUH Bank", accounts, 100);
	}

	
	public Bank(String name, ArrayList<BankAccount> accounts, int numberOfAccounts) {

		setName(name); 
        setNumberOfAccounts(numberOfAccounts);
        this.accounts = new ArrayList<>(numberOfAccounts);	
	}

	public String getName() {
		return name;
	}




	public void setName(String name) {
		if(name == null || name.isEmpty()) {
			throw new IllegalArgumentException("The bank name must not be null");
		}
		
		this.name = name;
	}




	public void setNumberOfAccounts(int numberOfAccounts) {
		if(numberOfAccounts <= 0) {
			throw new IllegalArgumentException("Number of accounts must be greater than 0");
		}
		
		this.numberOfAccounts = numberOfAccounts;
	}




	public void setAccounts(ArrayList<BankAccount> accounts) {
		if (accounts == null || accounts.size() > numberOfAccounts) {
		    throw new IllegalArgumentException(
		     "Accounts list must not be null and must not exceed the allowed number of accounts");
		}
		
		this.accounts = accounts;
	}
	

	public void addNew(String accountNumber, String accountName, double balance) {
		if(accounts.size() >= numberOfAccounts) {
			throw new IllegalArgumentException("Bank is full");
		}
		if(find(accountNumber) !=null) {
			throw new IllegalArgumentException("Account number already exists");
		}
		BankAccount acc = new BankAccount(accountNumber, accountName, balance);
        accounts.add(acc);
	}
	
	public BankAccount find(String accountNumber) {
		for (BankAccount acc : accounts) {
		    if (acc.getAccountNumber().equals(accountNumber)) {
		        return acc;
		    }
		}
		return null;
	}
	
	
	public double getTotalBalance() {
		double sum = 0.0;
		for (int i = 0; i < accounts.size(); i++) {
			sum +=accounts.get(i).getBalance();
		}
		return sum;
	}
	
	public int getNumberOfAccounts() {
		return accounts.size();
	}
	
	public BankAccount[] getAccounts() {
		return accounts.toArray(new BankAccount[0]);
	}


	@Override
	public String toString() {
		return "Bank [name=" + name + ", accounts=" + accounts + ", numberOfAccounts=" + numberOfAccounts + "]";
	}
	
	
	



	
	
	
	
	
}
