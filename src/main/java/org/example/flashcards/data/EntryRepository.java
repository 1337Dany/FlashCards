package org.example.flashcards.data;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Random;

@Repository
public class EntryRepository implements IEntryRepository, RepositoryContract {
    private final ArrayList<Entry> entries = new ArrayList<>();

    @Override
    public void add(Entry entry) {
        entries.add(entry);
    }

    @Override
    public String displayAll() {
        String allEntries = "";
        for (IEntry entry : entries) {
            allEntries += entry.getPolish() + " - " + entry.getEnglish() + " - " + entry.getGerman() + "\n";
        }
        return allEntries;
    }

    @Override
    public Entry getRandomEntry() {
        Random random = new Random();
        int randomIndex = random.nextInt(entries.size());
        return entries.get(randomIndex);
    }
}
