package entity;

import entity.usuario.User;

import java.sql.Date;

public class Loan {
    private User user;
    private Book book;
    private Date date;

    public Loan(User user, Book book, Date date){
        this.user = user;
        this.book = book;
        this.date = date;
    }
}
