
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Lab_session_9 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> marksList = new ArrayList<>();

        int choice;

        do {
            System.out.println("\nStudent Marks Management System ->");
            System.out.println("1. Add Marks");
            System.out.println("2. View All Marks");
            System.out.println("3. Update Marks");
            System.out.println("4. Delete Marks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    // CREATE
                    System.out.print("Enter marks to add: ");
                    int mark = sc.nextInt();
                    marksList.add(mark);
                    System.out.println("Marks added successfully!");
                    break;

                case 2:
                    // READ
                    System.out.println("\nStudent Marks List:");
                    if (marksList.isEmpty()) {
                        System.out.println("No records found.");
                    } 
                    else {
                        Iterator<Integer> itr = marksList.iterator();
                        while (itr.hasNext()) {
                            System.out.println(" - " + itr.next());
                        }
                    }
                    break;

                case 3:
                    // UPDATE
                    System.out.print("Enter index to update (0-based): ");
                    int indexToUpdate = sc.nextInt();
                    if (indexToUpdate >= 0 && indexToUpdate < marksList.size()) {
                        System.out.print("Enter new marks: ");
                        int newMarks = sc.nextInt();
                        marksList.set(indexToUpdate, newMarks);
                        System.out.println("Marks updated successfully!");
                    } 
                    else {
                        System.out.println("Invalid index!");
                    }
                    break;

                case 4:
                    // DELETE
                    System.out.print("Enter index to delete (0-based): ");
                    int indexToDelete = sc.nextInt();
                    if (indexToDelete >= 0 && indexToDelete < marksList.size()) {
                        marksList.remove(indexToDelete);
                        System.out.println("Marks deleted successfully!");
                    } 
                    else {
                        System.out.println("Invalid index!");
                    }
                    break;

                case 5:
                    System.out.println("Exiting...Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } 
        while (choice != 5);
        sc.close();
    }
}
