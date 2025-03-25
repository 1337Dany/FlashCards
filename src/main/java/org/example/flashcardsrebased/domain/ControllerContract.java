package org.example.flashcardsrebased.domain;

import org.example.flashcardsrebased.data.Entry;

public interface ControllerContract {
    String displayAll();
    void add(String entry);
    Entry getRandomEntry();
}
