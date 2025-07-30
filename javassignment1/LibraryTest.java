/*
 * 39.Design a class that acts as a library for the following kinds of media: book, video, and 
newspaper. Provide one version of the class that uses generics and one that does not.
The class should be with add and retrieve methods in order to add and retrieve values 
from the library.
 * 
 */

package javassignment1;
import java.util.*;
class Library<T> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public T getItem(int index) {
        return items.get(index);
    }
}

// Non-generic Version
class LibraryOld {
    private List<Object> items = new ArrayList<Object>();

    public void addItem(Object item) {
        items.add(item);
    }

    public Object getItem(int index) {
        return items.get(index);
    }
}

class Book {
    String title;
    Book(String title) { this.title = title; }
    public String toString() { return "Book: " + title; }
}

class Video {
    String name;
    Video(String name) { this.name = name; }
    public String toString() { return "Video: " + name; }
}

class Newspaper {
    String headline;
    Newspaper(String headline) { this.headline = headline; }
    public String toString() { return "Newspaper: " + headline; }
}

public class LibraryTest {
    public static void main(String[] args) {
        
    	System.out.println("------Testing generic version------");
    	
        Library<Book> bookLibrary = new Library<>();
        bookLibrary.addItem(new Book("Java Basics"));
        System.out.println(bookLibrary.getItem(0));

        Library<Video> videoLibrary = new Library<>();
        videoLibrary.addItem(new Video("Intro to AI"));
        System.out.println(videoLibrary.getItem(0));

        Library<Newspaper> newsLibrary = new Library<>();
        newsLibrary.addItem(new Newspaper("New Innovation in Tech"));
        System.out.println(newsLibrary.getItem(0));
        
        System.out.println("-----Testing non-generic version-----");

        // Testing non-generic version
        LibraryOld oldLibrary = new LibraryOld();
        oldLibrary.addItem(new Book("Legacy Java"));
        System.out.println(oldLibrary.getItem(0));
    }
}