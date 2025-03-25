package org.example.flashcardsrebased.data;

public interface RepositoryContract {
    String displayAll();
    void add(String entry);
    Entry getRandomEntry();
}
