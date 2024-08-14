package com.example.flashcards.beans;

import com.example.flashcards.dao.FlashcardCategoryRepository;
import com.example.flashcards.dao.FlashcardRepository;
import com.example.flashcards.jpa.Flashcard;
import com.example.flashcards.jpa.FlashcardCategory;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
@Getter
@Setter
public class IndexBean implements Serializable {

    @Inject
    private FlashcardRepository flashcardRepository;
    @Inject
    private FlashcardCategoryRepository flashcardCategoryRepository;

    private Flashcard flashcard = new Flashcard();
    private List<Flashcard> flashcardList;
    private FlashcardCategory flashcardCategory = new FlashcardCategory();
    private List<FlashcardCategory> flashcardCategoryList;

    @PostConstruct
    public void init() {
        flashcardList = flashcardRepository.findAll();
        flashcardCategoryList = flashcardCategoryRepository.findAll();
        flashcard = flashcardList.get(0);
    }

}
