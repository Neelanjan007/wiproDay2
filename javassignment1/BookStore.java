/*
 * 41.Create a class called BookStore with fields Bookid and Bookname.  
 * Sort using comparator and 
   display the output by sorting based on book name and book id.
 * 
 */


package javassignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class BookStore {
    int bookId;
    String bookName;

    BookStore(int bookId, String bookName) {
        this.bookId = bookId;
        this.bookName = bookName;
    }

    public String toString() {
        return "BookId: " + bookId + ", BookName: " + bookName;
    }

    public static void main(String[] args) {
        List<BookStore> books = new ArrayList<>();
        books.add(new BookStore(3, "Java"));
        books.add(new BookStore(1, "Algorithms"));
        books.add(new BookStore(2, "Data Structures"));

        System.out.println("Sorted by ID:");
        Collections.sort(books, new SortById());
        for (BookStore book : books) {
            System.out.println(book);
        }

        System.out.println("\nSorted by Name:");
        Collections.sort(books, new SortByName());
        for (BookStore book : books) {
            System.out.println(book);
        }
    }
}

class SortByName implements Comparator<BookStore> {
    public int compare(BookStore a, BookStore b) {
        return a.bookName.compareTo(b.bookName);
    }
}

class SortById implements Comparator<BookStore> {
    public int compare(BookStore a, BookStore b) {
        return a.bookId - b.bookId;
    }
}
