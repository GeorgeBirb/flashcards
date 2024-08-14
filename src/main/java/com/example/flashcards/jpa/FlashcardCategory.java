package com.example.flashcards.jpa;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "flashcard_category")
@Data
public class FlashcardCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer id;

    @Column(name = "category_name")
    private String name;

    @Column(name = "category_description")
    private String description;

}

