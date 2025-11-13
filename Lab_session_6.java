
import java.util.Scanner;

class LowBalanceException extends Exception {
    public LowBalanceException(String message) {
        super(message);
    }
}

class BankAccount {
    private String accountHolder;
    private double balance;

    // Constructor
    public BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void withdraw(double amount) throws LowBalanceException {
        if (amount > balance) {
            throw new LowBalanceException("Insufficient balance...Tried to withdraw " 
                                          + amount + ", but only " + balance + " rupees available.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful! Remaining balance: " + balance);
        }
    }

    public void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }
}


public class Lab_session_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Account Holder Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Initial Balance: ");
            double balance = sc.nextDouble();

            BankAccount account = new BankAccount(name, balance);

            System.out.print("Enter amount to withdraw: ");
            double amount = sc.nextDouble();

            account.withdraw(amount);

        } 

        catch (LowBalanceException e) {
            System.out.println(e.getMessage());
        } 

        catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

        finally {
            System.out.println("Transaction completed.");
        }
        sc.close();
    }
}
