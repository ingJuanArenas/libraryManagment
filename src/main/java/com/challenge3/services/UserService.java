package com.challenge3.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.challenge3.Exceptions.NotFoundException;
import com.challenge3.model.User;

public class UserService {
    private List<User> users;

    public UserService(List<User> users) {
        this.users = users;
    }

    public void addUser(String name, String email, String id, LocalDate registerData)throws NotFoundException{
         for (var user : users) {
            if (user.getId().equals(id)) {
                throw new NotFoundException("El id: " + id + " ya se encuentra registrado");
            }
        }
        users.add(new User(id, name, email, registerData));
    }

    public User getUserById(String id) throws NotFoundException {
        for (var user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        throw new NotFoundException("El id: " + id + " no fue encontrado");
    }
    

    public void deleteUser(String id) throws NotFoundException {
        boolean removed = users.removeIf(user -> user.getId().equals(id));
    
        if (!removed) {
            throw new NotFoundException("El id: " + id + " no fue encontrado");
        }
    }
    
    
    
}