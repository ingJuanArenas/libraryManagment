package com.challenge3.services;

import static org.mockito.Mockito.ignoreStubs;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.challenge3.Exceptions.NotFoundException;
import com.challenge3.model.Book;


public class  BookServiceTest  {
    private   BookService   bookService;
    private List<Book> books;
    @BeforeEach
    void setUp() {
        books = new ArrayList<>();
        bookService = new BookService(books); 
        books.add(new Book("1124345", "pepa pig", "pedro perez")); 
    }
    

    @Test
    void testAddBook() throws NotFoundException{
        var title = "peru pes";
        var author ="pedro pablo";
        var isbm= "134235";

        bookService.addBook(isbm, author, title, LocalDate.now());
    }

    
    @Test
    void testDeleteBook() throws NotFoundException {
        var isbm= "1124345";
    
        bookService.deleteBook(isbm); 
    
    }
    
    

    @Test
    void testGetBookById() throws NotFoundException{
        var isbm= "1124345";

          bookService.getBook(isbm);
    }
}
