package com.example.flashcards.dao;

import com.example.flashcards.jpa.Flashcard;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@ApplicationScoped
public class FlashcardRepository implements Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Flashcard flashcard) {
        entityManager.persist(flashcard);
    }

    public Flashcard findById(Integer id) {
        return entityManager.find(Flashcard.class, id);
    }

    public List<Flashcard> findAll() {
        return entityManager.createQuery("SELECT f FROM Flashcard f", Flashcard.class).getResultList();
    }
}

