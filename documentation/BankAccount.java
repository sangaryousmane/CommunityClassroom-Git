package documentation;

public class BankAccount {

    private double balance;

    public static void main(String[] args) {
        short c = 100, b = 300;
        int a = c + b;
        System.out.println(a);
    }

    public BankAccount(double balance) {
        this.balance = balance;
    }

    // A copy constructor
    public BankAccount(BankAccount account) {
        this.balance=account.balance;
    }

    public double withdraw(double amount) {
        if (this.balance < 1) {
            return this.balance;
        }
        return this.balance - amount;
    }

    public double deposit(double amount) {
        return this.balance + amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "balance=" + balance +
                '}';
    }


}
