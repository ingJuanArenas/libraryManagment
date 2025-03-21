package com.challenge3.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.challenge3.Exceptions.NotFoundException;
import com.challenge3.model.Book;

public class BookService {
    private List<Book> books;

    public BookService(List<Book> books) { 
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }


    public void addBook(String isbm, String author, String title, LocalDate registerDate) throws NotFoundException {
        for (var book : books) {
            if (book.getIsbm().equals(isbm)) {
                throw new NotFoundException("El ISBN: " + isbm + " ya está registrado");
            }
        }
        books.add(new Book(isbm, title, author)); // Se agrega después de verificar toda la lista
    }
    



    public Book getBook( String isbm)throws NotFoundException{
        for (var book : books) {
            if (book.getIsbm().equals(isbm)) {
                return book;
            }
        }
        throw new NotFoundException("El isbm:" +isbm+" no se encuentra regsitrado");

    }


    public void deleteBook(String isbm) throws NotFoundException {
        boolean removed = books.removeIf(book -> book.getIsbm().equals(isbm));
    
        if (!removed) {
            throw new NotFoundException("El isbm: " + isbm + " no fue encontrado.");
        }
    }
    
}
