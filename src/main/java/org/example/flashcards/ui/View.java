package org.example.flashcards.ui;

import org.example.flashcards.data.Entry;
import org.example.flashcards.domain.ControllerContract;
import org.example.flashcards.ui.gamemode.English;
import org.example.flashcards.ui.gamemode.GameContract;
import org.example.flashcards.ui.gamemode.German;
import org.example.flashcards.ui.gamemode.Polish;
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
        new Polish(this).start();
    }

    @Override
    public void startEnglishFlashcards() {
        new English(this).start();
    }

    @Override
    public void startGermanFlashcards() {
        new German(this).start();
    }

    @Override
    public Entry getRandomEntry() {
        return flashCardsController.getRandomEntry();
    }
}
