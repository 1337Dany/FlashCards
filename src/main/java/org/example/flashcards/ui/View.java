package org.example.flashcards.ui;

import org.example.flashcards.data.Entry;
import org.example.flashcards.domain.ControllerContract;
import org.example.flashcards.ui.gamemode.*;
import org.example.flashcards.ui.menu.Menu;
import org.example.flashcards.ui.menu.MenuCallback;
import org.springframework.stereotype.Component;

@Component
public class View implements MenuCallback, GameContract {
    private final ControllerContract flashCardsController;

    public View(ControllerContract flashCardsController) {
        this.flashCardsController = flashCardsController;

        Menu menu = new Menu(this);
        menu.init();
    }

    @Override
    public String displayAll() {
        return flashCardsController.displayAll();
    }

    @Override
    public void addEntry(String entry) {
        flashCardsController.add(entry);
    }

    @Override
    public void startPolishFlashcards() {
        new FlashCards(this, "polish");
    }

    @Override
    public void startEnglishFlashcards() {
        new FlashCards(this, "english");
    }

    @Override
    public void startGermanFlashcards() {
        new FlashCards(this, "german");
    }

    @Override
    public Entry getRandomEntry() {
        return flashCardsController.getRandomEntry();
    }
}
