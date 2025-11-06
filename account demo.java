abstract class Account {
    String accountHolder;
    double balance;

    Account(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

   
    abstract void calculateInterest();

   
    void displayDetails() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance       : " + balance);
    }
}


class SavingsAccount extends Account {
    double interestRate = 0.05; 

    SavingsAccount(String accountHolder, double balance) {
        super(accountHolder, balance);
    }

    void calculateInterest() {
        double interest = balance * interestRate;
        System.out.println("Savings Interest: " + interest);
    }
}


class CurrentAccount extends Account {
    double serviceCharge = 200.0;

    CurrentAccount(String accountHolder, double balance) {
        super(accountHolder, balance);
    }

    void calculateInterest() {
        System.out.println("Current Account: No interest applied.");
        System.out.println("Service Charge : " + serviceCharge);
    }
}

public class AccountDemo {
    public static void main(String[] args) {
       
        Account acc1 = new SavingsAccount("Ravi", 10000);
        Account acc2 = new CurrentAccount("Priya", 20000);

        System.out.println("--- Savings Account ---");
        acc1.displayDetails();
        acc1.calculateInterest();  

        System.out.println("\n--- Current Account ---");
        acc2.displayDetails();
        acc2.calculateInterest();  
    }
}
