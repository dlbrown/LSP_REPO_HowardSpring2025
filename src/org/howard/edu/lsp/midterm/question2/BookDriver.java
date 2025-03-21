package org.howard.edu.lsp.midterm.question2;

/**
 * Driver class to test the Book class
 */
class BookDriver {
    public static void main(String[] args) {
        // Creating book objects
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "123456789", 1925);
        Book book2 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "123456789", 1925);
        Book book3 = new Book("A Promised Land", "Barack Obama", "9780593239681", 2020);

        // Testing equality
        System.out.println(book1.equals(book2)); 
        System.out.println(book1.equals(book3)); 
        
        // Displaying book details
        System.out.println(book1); // Output: Title: Author: ISBN: Year Published: 
    }
}