
import java.util.ArrayList;

// Generic class Box<T>
class Box<T> {
    private ArrayList<T> items;

    public Box() {
        items = new ArrayList<>();
    }

    // Autoboxing happens automatically when adding primitives
    public void addItem(T item) {
        items.add(item);
    }

    public void displayItems() {
        System.out.println("Box contains:");
        for (T item : items) {
            System.out.println(" - " + item);
        }
    }
}

public class Lab_session_8 {
    public static void main(String[] args) {

        // Integer Box (Autoboxing: int → Integer)
        Box<Integer> intBox = new Box<>();
        intBox.addItem(10);
        intBox.addItem(20);
        intBox.addItem(30);
        intBox.displayItems();

        System.out.println();

        // Double Box (Autoboxing: double → Double)
        Box<Double> doubleBox = new Box<>();
        doubleBox.addItem(9.5);
        doubleBox.addItem(2.75);
        doubleBox.addItem(3.14);
        doubleBox.displayItems();

        System.out.println();

        // String Box
        Box<String> strBox = new Box<>();
        strBox.addItem("Mobile");
        strBox.addItem("Monitor");
        strBox.addItem("Headphones");
        strBox.displayItems();
    }
}
