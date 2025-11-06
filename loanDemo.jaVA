interface Loan {
    void showInterestRate();
}

class HomeLoan implements Loan {
    public void showInterestRate() {
        System.out.println("Home Loan Interest Rate is 8%");
    }
}

class CarLoan implements Loan {
    public void showInterestRate() {
        System.out.println("Car Loan Interest Rate is 9%");
    }
}

public class LoanDemo {
    public static void main(String[] args) {
        Loan home = new HomeLoan();
        Loan car = new CarLoan();

        System.out.println("---- Loan Details ----");
        home.showInterestRate();
        car.showInterestRate();
    }
}