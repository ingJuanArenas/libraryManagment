package com.challenge3.services;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.challenge3.Exceptions.NotFoundException;
import com.challenge3.model.Book;
import com.challenge3.model.BookStatus;
import com.challenge3.model.Loan;
import com.challenge3.model.User;

public class LoanServiceTest {
    private LoanService loanService;
    private BookService bookService;
    private UserService userService;
    private List<Loan> loans;

    @BeforeEach
    public void setUp() throws NotFoundException{
        bookService = Mockito.mock(BookService.class);
        userService = Mockito.mock(UserService.class);
        loans = new ArrayList<>();
        loanService = new LoanService(bookService, userService); 


        Mockito.when(userService.getUserById("1")).thenReturn(new User("1", "Juan Pérez", "juan@email.com", LocalDate.now()));
        Mockito.when(bookService.getBook("1234567890")).thenReturn(new Book("1234567890", "Libro de Prueba", "Autor X"));
    }

    @Test
    public void testAddLoan() throws NotFoundException {
        loanService.addLoan("1", "1234567890"); 
        assertEquals(1, loanService.getLoans().size()); 
    }


    @Test
    public void testReturnBook() throws NotFoundException {
        
        loanService.addLoan("1", "1234567890");

       
        loanService.returnBook("1", "1234567890");

        assertEquals(BookStatus.FREE, loanService.getLoans().get(0).getStatus());
    }

    
}
