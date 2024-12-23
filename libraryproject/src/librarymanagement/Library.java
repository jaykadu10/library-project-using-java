	package librarymanagement;

	import java.util.*;

	public class Library {
	    private List<Book> books;

	    public Library() {
	        books = new ArrayList<>();
	    }

	    public void addBook(Book book) {
	        books.add(book);
	    }

	    public Book getBookById(int id) {
	        for (Book book : books) {
	            if (book.getId() == id) {
	                return book;
	            }
	        }
	        return null;
	    }

	    public void displayBooks() {
	        for (Book book : books) {
	            System.out.println("ID: " + book.getId() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Borrowed: " + book.isBorrowed());
	        }
	    }
	}

