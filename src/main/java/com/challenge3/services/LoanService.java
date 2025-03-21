package com.challenge3.services;


import java.util.ArrayList;
import java.util.List;

import com.challenge3.Exceptions.NotFoundException;
import com.challenge3.model.BookStatus;
import com.challenge3.model.Loan;

public class LoanService {
    private BookService bookService;
    private UserService userService;
    private List<Loan> loans;

    public LoanService(BookService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
        this.loans = new ArrayList<>();
    }


    public void addLoan(String id, String isbm)throws NotFoundException{
        var user = userService.getUserById(id);
        var book = bookService.getBook(isbm);
        loans.add(new Loan(user, book,BookStatus.LOAN));
 
    }

    public List<Loan> getLoans(){
        return loans;
    }
    public void returnBook(String id, String isbm) throws NotFoundException{
        for (var loan : loans) {
            if (loan.getUser().getId().equals(id)
            && loan.getBook().getIsbm().equals(isbm)
            && loan.getStatus().equals(BookStatus.LOAN)) {
                loan.setStatus(BookStatus.FREE);
                return;
            }
        }
        throw new NotFoundException("No se ha encontrado el prestamo con los datos. ISBM: "+isbm+" ID: "+id);
       }
    
}
