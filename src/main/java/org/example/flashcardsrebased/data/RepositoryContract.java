package org.example.flashcardsrebased.data;

public interface RepositoryContract {
    String displayAll();
    void add(String entry);
    Entry getRandomEntry();
    void delete(long entryId);
    void modify(long entryId, String entry);
    Entry find(String entryId);
    String displayAllSorted(String sortBy);
}
