package iuh.fit.oop;

/*
 * @author:  Pham Cao Thien Nhan
 * @created: 19-Sep-2025
 */

import java.util.Scanner;

public class BankTester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank("IUH Bank", null, 100);
        System.out.println(bank);
        int choice;
        do {
            System.out.println("\nWelcome to " + bank.getName());
            System.out.println("1. Open new account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. The total balance of all bank accounts in the bank");
            System.out.println("6. Print all bank accounts");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: 
                    System.out.println("Add new account");
                    System.out.print("Enter account number: ");
                    String accNum = sc.nextLine();
                    System.out.print("Enter account name: ");
                    String accName = sc.nextLine();
                    System.out.print("Enter balance: ");
                    double balance = sc.nextDouble();
                    try {
                        bank.addNew(accNum, accName, balance);
                        System.out.println("Account created successfully!");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2: 
                    System.out.print("Enter account number: ");
                    accNum = sc.nextLine();
                    BankAccount accDeposit = bank.find(accNum);
                    if (accDeposit != null) {
                        System.out.print("Enter deposit amount: ");
                        double amount = sc.nextDouble();
                        try {
                            accDeposit.deposit(amount);
                            System.out.println("Deposit successful. New balance: " + accDeposit.getBalance());
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 3: 
                    System.out.print("Enter account number: ");
                    accNum = sc.nextLine();
                    BankAccount accWithdraw = bank.find(accNum);
                    if (accWithdraw != null) {
                        System.out.print("Enter withdraw amount: ");
                        double amount = sc.nextDouble();
                        try {
                            accWithdraw.withdraw(amount);
                            System.out.println("Withdraw successful. New balance: " + accWithdraw.getBalance());
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 4: 
                    System.out.print("Enter source account number: ");
                    String srcNum = sc.nextLine();
                    BankAccount srcAcc = bank.find(srcNum);

                    System.out.print("Enter destination account number: ");
                    String destNum = sc.nextLine();
                    BankAccount destAcc = bank.find(destNum);

                    if (srcAcc != null && destAcc != null) {
                        System.out.print("Enter transfer amount: ");
                        double amount = sc.nextDouble();
                        try {
                            srcAcc.transfer(destAcc, amount);
                            System.out.println("Transfer successful.");
                            System.out.println("Source balance: " + srcAcc.getBalance());
                            System.out.println("Destination balance: " + destAcc.getBalance());
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    } else {
                        System.out.println("One or both accounts not found!");
                    }
                    break;

                case 5: 
                    System.out.println("Total balance in bank: " + bank.getTotalBalance());
                    break;

                case 6: 
                    for (BankAccount acc : bank.getAccounts()) {
                        System.out.println(acc);
                    }
                    break;

                case 7: 
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice, try again.");
            }
        } while (choice != 7);

        sc.close();
    }
}

