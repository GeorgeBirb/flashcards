package com.example.flashcards.beans;

import com.example.flashcards.dao.FlashcardCategoryRepository;
import com.example.flashcards.dao.FlashcardRepository;
import com.example.flashcards.jpa.Flashcard;
import com.example.flashcards.jpa.FlashcardCategory;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
@Getter
@Setter
public class IndexBean implements Serializable {

    @Inject
    private FlashcardRepository flashcardRepository;
    @Inject
    private FlashcardCategoryRepository flashcardCategoryRepository;

    private Flashcard selectedFlashcard = new Flashcard();
    private List<Flashcard> flashcardList;
    private FlashcardCategory flashcardCategory = new FlashcardCategory();
    private List<FlashcardCategory> flashcardCategoryList;
    private String answer = "";

    @PostConstruct
    public void init() {
        flashcardList = flashcardRepository.findAll();
        flashcardCategoryList = flashcardCategoryRepository.findAll();
    }

    public void selectFlashcard(Flashcard flashcard) {
        this.selectedFlashcard = flashcard;
        this.answer = ""; // Clear previous answer if needed
    }

    public void submitAnswer() {
        // Process the answer, e.g., save it or check correctness
        System.out.println("Answer for question '" + selectedFlashcard.getQuestion() + "': " + answer);
    }

}
