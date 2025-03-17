package org.example.flashcards.data;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class EntryRepository implements IEntryRepository, RepositoryContract {
    private final IFileService fileService;
    private final ArrayList<IEntry> entries = new ArrayList<>();

    EntryRepository(IFileService fileService) {
        this.fileService = fileService;
        fileService.loadData();
    }

    @Override
    public void add(IEntry entry) {
        entries.add(entry);
        fileService.saveData(entry);
    }

    @Override
    public String displayAll() {
        String allEntries = "";
        for (IEntry entry : entries) {
            allEntries = entry.getPolish() + " - " + entry.getEnglish() + " - " + entry.getGerman() + "\n";
        }
        return allEntries;
    }
}
