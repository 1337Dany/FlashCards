package org.example.flashcards.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "org.example.flashcards.data")
@ComponentScan(basePackages = "org.example.flashcards.domain")
@ComponentScan(basePackages = "org.example.flashcards.ui")
@ComponentScan(basePackages = "org.example.flashcards.ui.profiles.configs")
public class FlashcardsApp {

    public static void main(String[] args) {
        SpringApplication.run(FlashcardsApp.class, args);
    }
}