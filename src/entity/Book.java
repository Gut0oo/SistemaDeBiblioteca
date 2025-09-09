package entity;

import enums.BookStatus;

public class Book {
    private String title, author;
    private int id_book;
    private BookStatus status;

    public Book(String title, String author, int id_book, BookStatus status){
        this.title = title;
        this.author = author;
        this.id_book = id_book;
        this.status = status;
    }

    public int getId_book() {
        return id_book;
    }

    public void setId_book(int id_book) {
        this.id_book = id_book;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

}
