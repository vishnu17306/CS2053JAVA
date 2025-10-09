class Books{
    public String Title;
    public String Author;
    public String Publisher;
    public int Number_of_pages;

    // Constructor
    public Books(String Title, String Author, String Publisher, int Number_of_pages){
        this.Title = Title;
        this.Author = Author;
        this.Publisher = Publisher;
    }

    public void display(){
        System.out.println("The title of the book is: " + Title);
        System.out.println("Authored by: " + Author);
        System.out.println("Published by: " + Publisher);
        System.out.println("with a total of: " + Number_of_pages + " Pages");
    }
}
public class Lab_session_1 {
    public static void main(String[] args) {
        Books info = new Books("animal farm ", "RK NARAYAN", "Bloomsbury Publications", 352);
        info.display();
    }
}