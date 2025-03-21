package com.challenge3.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.challenge3.Exceptions.NotFoundException;
import com.challenge3.model.User;

public class UserServiceTest  {
    private List<User> users;
    private UserService userService;
    

    @BeforeEach
    void setUp() {
        users = new ArrayList<>();
        userService = new UserService(users);
    }
    

    @Test
    void testAddUser() {
        var name = "pepitooooo";
        var email = "pp@gmail.com";
        var id = "1124345";

        assertDoesNotThrow(() -> userService.addUser(name, email, id, LocalDate.now()));
    }

    @Test
    void testDeleteUser() throws NotFoundException {
        var user = new User("1124345", "Juan","ajsajdasjd", LocalDate.now());
        users.add(user); 
    
        System.out.println("Antes de eliminar: " + users);
    
        userService.deleteUser("1124345");
    
        System.out.println("Después de eliminar: " + users);
    }
    
    
    

    @Test
    void testGetUserById() {
        var id = "1124345";
        var name = "pepitooooo";
        var email = "pp@gmail.com";

        
        assertDoesNotThrow(() -> userService.addUser(name, email, id, LocalDate.now()));

        assertDoesNotThrow(() -> {
            User user = userService.getUserById(id);
            assertNotNull(user);
            assertEquals(id, user.getId());
            assertEquals(name, user.getName());
            assertEquals(email, user.getEmail());
        });
    }
}
