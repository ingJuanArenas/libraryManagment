package com.challenge3.model;

import java.time.LocalDate;

public class User {
    private String id;
    private String name;
    private String email; 
    private LocalDate registerData;

    public User(String id, String name, String email, LocalDate registerData) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.registerData = registerData;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getRegisterData() {
        return registerData;
    }

    

    
}
