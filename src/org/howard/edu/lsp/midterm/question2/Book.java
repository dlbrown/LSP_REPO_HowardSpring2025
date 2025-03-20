package org.howard.edu.lsp.midterm.question2;

/**
 * Book has title, author, ISBN, and year published.
 */
public class Book {
    private String title;
    private String author;
    private String ISBN;
    private int yearPublished;

    /**
     * Build a new book
     * @param title The title of the book.
     * @param author The author of the book.
     * @param ISBN The unique ISBN identifier of the book.
     * @param yearPublished The year the book was published.
     */
    public Book(String title, String author, String ISBN, int yearPublished) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.yearPublished = yearPublished;
    }

    /**
     * Gets the title of the book.
     * @return Book title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * Author of the book.
     * @return The book's author.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * ISBN of the book.
     * @return The book's ISBN.
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * Published year the book.
     * @return The year of publication.
     */
    public int getYearPublished() {
        return yearPublished;
    }

    /**
     * Sets title.
     * @param title The new title of the book.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets author
     * @param author The new author of the book.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Sets ISBN.
     * @param ISBN The new ISBN of the book.
     */
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    /**
     * Sets the year
     * @param yearPublished The new year of publication.
     */
    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    /**
     * Compares with another book.
     * Two books are are the same if ISBN and author are the same
     * @param obj The object to compare to.
     * @return true if the books are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return this.ISBN.equals(book.ISBN) && this.author.equals(book.author);
    }

    /**
     * String representation of the book.
     * @return A formatted string containing book details.
     */
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + ISBN + ", Year Published: " + yearPublished;
    }
}
