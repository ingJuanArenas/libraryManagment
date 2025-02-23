package com.challenge3.model;


public class Book {
     String isbm;
     String title;
     String author;
     
    public Book(String isbm, String title, String author) {
        this.isbm = isbm;
        this.title = title;
        this.author = author;
    }

    public String getIsbm() {
        return isbm;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
    
}
