package org.example.flashcards.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FlashcardsApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(FlashcardsApp.class, args);
        new FlashCardsController(context);
    }
}