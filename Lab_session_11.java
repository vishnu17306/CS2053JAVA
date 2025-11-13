
import java.util.*;

class Product {
    private int id;
    private String name;
    private double price;

    // Constructor
    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return String.format("ID: %d | Name: %-10s | Price: %.2f", id, name, price);
    }
}

public class Lab_session_11 {
    public static void main(String[] args) {

        // Creating a list of products
        List<Product> products = new ArrayList<>();
        products.add(new Product(101, "Speakers", 15000.0));
        products.add(new Product(102, "Airpods", 25000.0));
        products.add(new Product(103, "Desktop", 17000.0));
        products.add(new Product(104, "Keyboard", 1200.0));
        products.add(new Product(105, "Ram", 8500.0));

        System.out.println("=== Original Product List ===");
        products.forEach(System.out::println);

        // Sorting by Price
        products.sort((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
        System.out.println("\n=== Products Sorted by Price (Ascending) ===");
        products.forEach(System.out::println);

        // Sorting by Name
        products.sort((p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName()));
        System.out.println("\n=== Products Sorted by Name (Alphabetical) ===");
        products.forEach(System.out::println);

        // Using a block lambda to find the most expensive product
        Product maxProduct = products.stream()
                .max((p1, p2) -> {
                    if (p1.getPrice() > p2.getPrice()) return 1;
                    else if (p1.getPrice() < p2.getPrice()) return -1;
                    else return 0;
                })
                .orElse(null);

        System.out.println("\nThe Most Expensive Product:");
        System.out.println(maxProduct);
    }
}
