package org.example.flashcardsrebased.ui;

import org.example.flashcardsrebased.data.Entry;
import org.example.flashcardsrebased.domain.ControllerContract;
import org.example.flashcardsrebased.ui.gamemode.*;
import org.example.flashcardsrebased.ui.menu.Menu;
import org.example.flashcardsrebased.ui.menu.MenuContract;
import org.example.flashcardsrebased.ui.profiles.formatters.EntryFormatter;
import org.springframework.stereotype.Component;

@Component
public class View implements MenuContract, GameContract {
    private final ControllerContract flashCardsController;
    private final EntryFormatter entryFormatter;

    public View(ControllerContract flashCardsController, EntryFormatter entryFormatter) {
        this.flashCardsController = flashCardsController;
        this.entryFormatter = entryFormatter;

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
        new FlashCards(this, entryFormatter).start("polish");
}

    @Override
    public void startEnglishFlashcards() {
        new FlashCards(this, entryFormatter).start("english");
    }

    @Override
    public void startGermanFlashcards() {
        new FlashCards(this, entryFormatter).start("german");
    }

    @Override
    public void deleteEntry(long entryId) {
        flashCardsController.delete(entryId);
    }

    @Override
    public void modifyEntry(long entryId, String entry) {
        flashCardsController.modify(entryId, entry);
    }

    @Override
    public Entry findEntry(String entryId) {
        return flashCardsController.find(entryId);
    }

    @Override
    public String displayAllSorted(String sortBy) {
        return flashCardsController.displayAllSorted(sortBy);
    }

    @Override
    public Entry getRandomEntry() {
        return flashCardsController.getRandomEntry();
    }
}
