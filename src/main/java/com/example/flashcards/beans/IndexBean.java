package com.example.flashcards.beans;

import com.example.flashcards.dao.FlashcardRepository;
import com.example.flashcards.jpa.Flashcard;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class IndexBean implements Serializable {

    @Inject
    private FlashcardRepository flashcardRepository;

    private Flashcard flashcard = new Flashcard();
    private List<Flashcard> flashcards;
    private String message;

    @PostConstruct
    public void init() {
        message = "Hello, world"; // This initializes the message when the bean is created.
        flashcards = getFlashcards();
    }


    public List<Flashcard> getFlashcards() {
        if (flashcards == null) {
            flashcards = flashcardRepository.findAll();
        }
        return flashcards;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
