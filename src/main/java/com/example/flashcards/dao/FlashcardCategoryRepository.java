package com.example.flashcards.dao;

import com.example.flashcards.jpa.FlashcardCategory;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.io.Serializable;
import java.util.List;

@ApplicationScoped
public class FlashcardCategoryRepository implements Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(FlashcardCategory flashcardCategory) {
        entityManager.persist(flashcardCategory);
    }

    public FlashcardCategory findById(Integer id) {
        return entityManager.find(FlashcardCategory.class, id);
    }

    public List<FlashcardCategory> findAll() {
        return entityManager.createQuery("SELECT f FROM FlashcardCategory f", FlashcardCategory.class).getResultList();
    }
}

