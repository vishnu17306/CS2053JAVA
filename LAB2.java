import java.util.Scanner;

class Employee {
    String name;
    String department;
    double salary;

    // Constructor with correct parameter spelling
    Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: ₹" + salary);
        System.out.println("x-------x-------");
    }

    // Corrected method name
    void updateSalary(double increment) {
        salary += increment;
    }
}

public class LAB2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter employee name:");
        String name = sc.nextLine();

        System.out.println("Enter department:");
        String department = sc.nextLine();  // fixed type

        System.out.println("Enter salary:");
        double salary = sc.nextDouble();

        Employee em = new Employee(name, department, salary); // fixed variable name

        if (args.length > 0) {
            double increment = Double.parseDouble(args[0]);
            em.updateSalary(increment); // fixed method name
            System.out.println("Salary updated by ₹" + increment);
        }

        em.displayDetails();
        sc.close();
    }
}
