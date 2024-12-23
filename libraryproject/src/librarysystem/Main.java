

package librarysystem;

import librarymanagement.*;
import java.time.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        library.addBook(new Book(1, "Java Programming", "Author A"));
        library.addBook(new Book(2, "Python Basics", "Author B"));
        library.addBook(new Book(3, "Data Structures", "Author C"));

        System.out.println("Welcome to the Library System");

        while (true) {
            System.out.println("1. Display Books\n2. Borrow Book\n3. Return Book\n4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    library.displayBooks();
                    break;
                case 2:
                    System.out.print("Enter Book ID to borrow: ");
                    int borrowId = scanner.nextInt();
                    Book bookToBorrow = library.getBookById(borrowId);
                    if (bookToBorrow != null && !bookToBorrow.isBorrowed()) {
                        bookToBorrow.borrowBook();
                        IssueDetails issueDetails = new IssueDetails(LocalDate.now(), 14);
                        System.out.println("Book borrowed. Due date: " + issueDetails.getDueDate());
                    } else {
                        System.out.println("Book is not available or invalid ID.");
                    }
                    break;
                case 3:
                    System.out.print("Enter Book ID to return: ");
                    int returnId = scanner.nextInt();
                    Book bookToReturn = library.getBookById(returnId);
                    if (bookToReturn != null && bookToReturn.isBorrowed()) {
                        bookToReturn.returnBook();
                        System.out.print("Enter return date (yyyy-mm-dd): ");
                        LocalDate returnDate = LocalDate.parse(scanner.next());
                        IssueDetails returnDetails = new IssueDetails(LocalDate.now(), 14);
                        returnDetails.returnBook(returnDate);
                        System.out.println("Fine: " + returnDetails.calculateFine());
                    } else {
                        System.out.println("Book is not borrowed or invalid ID.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting Library System. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
