// Abstract base class
abstract class Account {
    String accountHolder;
    double balance;

    // Constructor
    Account(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Abstract method (must be implemented by subclasses)
    abstract void calculateInterest();

    // Common (non-abstract) method
    void displayDetails() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: ₹" + balance);
    }
}

// SavingsAccount class
class SavingsAccount extends Account {
    double interestRate = 0.04; // 4%

    SavingsAccount(String accountHolder, double balance) {
        super(accountHolder, balance);
    }

    @Override
    void calculateInterest() {
        double interest = balance * interestRate;
        System.out.println("Savings Account Interest: ₹" + interest);
    }
}

// CurrentAccount class
class CurrentAccount extends Account {
    double overdraftLimit = 5000;

    CurrentAccount(String accountHolder, double balance) {
        super(accountHolder, balance);
    }

    @Override
    void calculateInterest() {
        System.out.println("Current Account: No interest. Overdraft limit = ₹" + overdraftLimit);
    }
}

// Main class to test polymorphism
public class BankDemo {
    public static void main(String[] args) {
        // Polymorphic references
        Account acc1 = new SavingsAccount("Vishnu", 10000);
        Account acc2 = new CurrentAccount("Ravi", 15000);

        // Dynamic method dispatch — calls the overridden version
        acc1.displayDetails();
        acc1.calculateInterest();

        System.out.println("-----------------------------");

        acc2.displayDetails();
        acc2.calculateInterest();
    }
}

    

