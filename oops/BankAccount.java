package oops;

public class BankAccount {
    private double balance;

    public BankAccount() {
    }

    public BankAccount(String str) {
        this.balance = Double.parseDouble(str);
    }

    public BankAccount(double amount) {
        this.balance = amount;
    }

    public void deposit(String str) {
        this.balance += Double.parseDouble(str);
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (this.balance <= 0.0) {
            System.out.println("Sorry!! Account is empty.");
            this.balance = 0.0;
        }
        this.balance -= amount;
    }

    public void withdraw(String str) {
        if (this.balance <= 0.0) {
            System.out.println("Sorry!! Account is empty.");
            this.balance = 0.0;
        }
        this.balance -= Double.parseDouble(str);
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" + "balance=" + balance + '}';
    }
}
