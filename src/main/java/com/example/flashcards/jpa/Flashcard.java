package com.example.flashcards.jpa;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "flashcard")
@Data
public class Flashcard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "question")
    private String question;

    @Column(name = "answer")
    private String answer;

    @ManyToOne
    @JoinColumn(name = "category_id") // Foreign key column in the flashcard table
    private FlashcardCategory category;

}

