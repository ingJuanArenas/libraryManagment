import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.time.LocalDate;
import com.challenge3.Exceptions.NotFoundException;
import com.challenge3.model.Book;
import com.challenge3.model.BookStatus;
import com.challenge3.model.User;
import com.challenge3.services.BookService;
import com.challenge3.services.LoanService;
import com.challenge3.services.UserService;

public class LoanServiceTest {

    private LoanService loanService;
    private BookService bookService;
    private UserService userService;

    @BeforeEach
    public void setUp() {
        bookService = Mockito.mock(BookService.class);
        userService = Mockito.mock(UserService.class);
        loanService = new LoanService(bookService, userService);
    }

    @Test
    public void testAddLoan() throws NotFoundException {
        User user = new User("1", "John Doe", "john@example.com", LocalDate.now());
        Book book = new Book("1234567890", "Test Author", "Test Title");

        Mockito.when(userService.getUserById("1")).thenReturn(user);
        Mockito.when(bookService.getBook("1234567890")).thenReturn(book);

        loanService.addLoan("1", "1234567890");

        assertEquals(1, loanService.getLoans().size());
        assertEquals(BookStatus.LOAN, loanService.getLoans().get(0).getStatus());
        assertEquals(user, loanService.getLoans().get(0).getUser());
        assertEquals(book, loanService.getLoans().get(0).getBook());
    }

    @Test
    public void testAddLoanUserNotFound() {
        Mockito.when(userService.getUserById("1")).thenThrow(new NotFoundException("User not found"));

        NotFoundException thrown = assertThrows(NotFoundException.class, () -> {
            loanService.addLoan("1", "1234567890");
        });

        assertEquals("User not found", thrown.getMessage());
    }

    @Test
    public void testAddLoanBookNotFound() throws NotFoundException {
        User user = new User("1", "John Doe", "john@example.com", LocalDate.now());
        Mockito.when(userService.getUserById("1")).thenReturn(user);
        Mockito.when(bookService.getBook("1234567890")).thenThrow(new NotFoundException("Book not found"));

        NotFoundException thrown = assertThrows(NotFoundException.class, () -> {
            loanService.addLoan("1", "1234567890");
        });

        assertEquals("Book not found", thrown.getMessage());
    }
}