package org.example.flashcards.domain;

import org.example.flashcards.data.Entry;

public interface ControllerContract {
    String displayAll();
    void add(String entry);
    Entry getRandomEntry();
}
