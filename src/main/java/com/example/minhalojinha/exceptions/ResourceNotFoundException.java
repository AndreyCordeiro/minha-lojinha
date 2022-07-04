package com.example.minhalojinha.exceptions;

public class ResourceNotFoundException extends Exception{
    public ResourceNotFoundException() {
    }

    public ResourceNotFoundException(String msg) {
        super (msg);
    }
}
