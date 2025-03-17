package org.example.flashcards.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlashcardsApp {

    public static void main(String[] args) {
        SpringApplication.run(FlashcardsApp.class, args);
        new FlashCardsController();
    }
}