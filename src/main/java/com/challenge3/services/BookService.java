package com.challenge3.services;

import java.util.ArrayList;
import java.util.List;

import com.challenge3.Exceptions.NotFoundException;
import com.challenge3.model.Book;

public class BookService {
    private List<Book> books;

    public BookService(){
        books= new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }


    public void addBook( String isbm,String author,String title)throws NotFoundException{
        for (var book : books) {
            if (!book.getIsbm().equals(isbm)) {
                books.add(new Book(isbm, title, author));
                //si no existe lo crea
            }
        }

        throw new NotFoundException("El isbm: "+ isbm+" ya esta regitrado");
    }



    public Book getBook( String isbm)throws NotFoundException{
        for (var book : books) {
            if (book.getIsbm().equals(isbm)) {
                return book;
            }
        }
        throw new NotFoundException("El isbm:" +isbm+" no se encuentra regsitrado");

    }


    public void  deleteBook( String isbm)throws NotFoundException{
        for (var book : books) {
            if (book.getIsbm().equals(isbm)) {
                books.remove(isbm);
            }
        }
        throw new NotFoundException("El isbm: "+isbm+" no fue encontrado.");

    }
}
