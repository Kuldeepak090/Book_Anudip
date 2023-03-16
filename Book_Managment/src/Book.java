import java.util.Scanner;

public class Book {
    private int bookid;
    private String bookName;
    private double bookPrice;
    private String authorName;
    private static String libraryName = "Central Library";
    private boolean availability;

    // Constructor to initialize the book object with default values
    public Book() {
        this.bookid = 0;
        this.bookName = "";
        this.bookPrice = 0.0;
        this.authorName = "";
        this.availability = true;
    }

    // Method to create a new book object with user input values
    public void createBook() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter book ID: ");
        this.bookid = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter book name: ");
        this.bookName = sc.nextLine();
        System.out.print("Enter book price: ");
        this.bookPrice = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter author name: ");
        this.authorName = sc.nextLine();
        this.availability = true;
        System.out.println("Book added successfully!");
    }

    // Method to display all the book details
    public void displayBook() {
        System.out.println("Book ID: " + this.bookid);
        System.out.println("Book Name: " + this.bookName);
        System.out.println("Book Price: " + this.bookPrice);
        System.out.println("Author Name: " + this.authorName);
        System.out.println("Library Name: " + libraryName);
        System.out.println("Availability: " + (this.availability ? "Available" : "Not Available"));
    }

    // Method to display a specific book details based on book name
    public void displayBookByName(String bookName) {
        if (this.bookName.equals(bookName)) {
            displayBook();
        }
    }

    // Method to borrow a book if it is available
    public void borrowBook(String bookName) {
        if (this.bookName.equals(bookName)) {
            if (this.availability) {
                this.availability = false;
                System.out.println("Book borrowed successfully!");
            } else {
                System.out.println("Book not available!");
            }
        }
    }

    public static void main(String[] args) {
        Book[] books = new Book[5];
        for (int i = 0; i < books.length; i++) {
            books[i] = new Book();
            books[i].createBook();
        }

        System.out.println("All Books Details:");
        for (int i = 0; i < books.length; i++) {
            books[i].displayBook();
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter book name to display details: ");
        String bookName = sc.nextLine();
        for (int i = 0; i < books.length; i++) {
            books[i].displayBookByName(bookName);
        }

        System.out.print("Enter book name to borrow: ");
        bookName = sc.nextLine();
        for (int i = 0; i < books.length; i++) {
            books[i].borrowBook(bookName);
        }
    }
}
