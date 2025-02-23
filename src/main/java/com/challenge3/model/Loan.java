package com.challenge3.model;

import java.time.LocalDate;

public class Loan {
    private User user;
    private Book book;
    private LocalDate loanData;
    private BookStatus status;
    public Loan(User user, Book book, LocalDate loanData, BookStatus status) {
        this.user = user;
        this.book = book;
        this.loanData = loanData;
        this.status = status;
    }

    public Loan(User user, Book book, BookStatus status) {
        this.user = user;
        this.book = book;
        this.status = status;
    }
    public BookStatus getStatus() {
        return status;
    }
    public void setStatus(BookStatus status) {
        this.status = status;
    }
    public User getUser() {
        return user;
    }
    public Book getBook() {
        return book;
    }
    public LocalDate getLoanData() {
        return loanData;
    }

    

}
