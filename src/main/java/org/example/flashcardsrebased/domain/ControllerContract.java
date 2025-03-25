package org.example.flashcardsrebased.domain;

import org.example.flashcardsrebased.data.Entry;

public interface ControllerContract {
    String displayAll();
    void add(String entry);
    Entry getRandomEntry();
    void delete(long entryId);
    void modify(long entryId, String entry);
    Entry find(String entryId);
    String displayAllSorted(String sortBy);
}
