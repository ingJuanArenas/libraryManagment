package com.challenge3.Exceptions;

public class NotFoundException extends Exception {
    String message;
    public NotFoundException(String message){
            this.message= message;
    }
}
