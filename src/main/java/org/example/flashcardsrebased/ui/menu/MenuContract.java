package org.example.flashcardsrebased.ui.menu;

import org.example.flashcardsrebased.data.Entry;

public interface MenuContract {
    String displayAll();
    void addEntry(String entry);
    void startPolishFlashcards();
    void startEnglishFlashcards();
    void startGermanFlashcards();
    void deleteEntry(long entryId);
    void modifyEntry(long entryId, String entry);
    Entry findEntry(String entryId);
    String displayAllSorted(String sortBy);
}
