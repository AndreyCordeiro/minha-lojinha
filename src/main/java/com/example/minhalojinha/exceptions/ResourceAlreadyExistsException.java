package com.example.minhalojinha.exceptions;

public class ResourceAlreadyExistsException extends Exception {
    public ResourceAlreadyExistsException() {
    }

    public ResourceAlreadyExistsException (String msg) {
        super (msg);
    }
}
