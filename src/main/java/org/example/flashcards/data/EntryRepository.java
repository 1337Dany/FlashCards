package org.example.flashcards.data;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class EntryRepository implements IEntryRepository{
    private final ArrayList<IEntry> entries = new ArrayList<>();

    @Override
    public void add(IEntry entry) {
        entries.add(entry);
    }

    @Override
    public void displayAll() {
        for (IEntry entry : entries) {
            System.out.println(entry.getTerm() + " - " + entry.getDefinition());
        }
    }
}
