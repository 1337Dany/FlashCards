package org.example.flashcardsrebased.ui;

import org.example.flashcardsrebased.data.Entry;
import org.example.flashcardsrebased.domain.ControllerContract;
import org.example.flashcardsrebased.ui.gamemode.*;
import org.example.flashcardsrebased.ui.menu.Menu;
import org.example.flashcardsrebased.ui.menu.MenuCallback;
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
