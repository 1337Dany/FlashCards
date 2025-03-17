package org.example.flashcards.ui;

import org.example.flashcards.domain.FlashCardsController;
import org.springframework.stereotype.Component;

@Component
public class View implements ViewContract {
    private FlashCardsController flashCardsController;
}
