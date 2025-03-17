package org.example.flashcards.ui.menu;

public interface MenuCallback {
    String displayAll();
    void addEntry(String entry);
    void startPolishFlashcards();
    void startEnglishFlashcards();
    void startGermanFlashcards();
}
