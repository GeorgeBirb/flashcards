package com.example.flashcards.beans;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@SessionScoped
public class IndexBean implements Serializable {

    private String message;

    @PostConstruct
    public void init() {
        message = "Hello, world"; // This initializes the message when the bean is created.
        System.out.println("HelloWorldBean initialized");
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
