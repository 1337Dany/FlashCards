package org.example.flashcardsrebased.data;

import org.example.flashcardsrebased.data.exception.AutomationException;
import org.example.flashcardsrebased.ui.profiles.formatters.EntryFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Repository
public class EntryRepository implements RepositoryContract {
    private final EntryAutomationRepository entryAutomationRepository;
    private final EntryFormatter entryFormatter;

    @Autowired
    public EntryRepository(EntryAutomationRepository entryAutomationRepository, EntryFormatter entryFormatter) {
        this.entryAutomationRepository = entryAutomationRepository;
        this.entryFormatter = entryFormatter;
    }

    @Transactional
    @Override
    public String displayAll() {
        List<Entry> allEntries = entryAutomationRepository.findAll();
        return entryFormatter.format(allEntries.toString());
    }

    @Transactional
    @Override
    public void add(String entry) {
       String[] parts = entry.split(",");
        Entry tmp = new Entry(parts[0], parts[1], parts[2]);
        entryAutomationRepository.save(tmp);
    }

    @Transactional
    @Override
    public Entry getRandomEntry() {
        List<Entry> entries = entryAutomationRepository.findAll();
        if (entries.isEmpty()) {
            throw new AutomationException("No entries found");
        }
        Random random = new Random();
        return entries.get(random.nextInt(entries.size()));
    }

    @Transactional
    @Override
    public void delete(long entryId) {
        Entry entry = entryAutomationRepository.findById(entryId)
                .orElseThrow(() -> new AutomationException("Entry not found"));
        entryAutomationRepository.delete(entry);
    }

    @Transactional
    @Override
    public void modify(long entryId, String entry) {
        Entry entryToUpdate = entryAutomationRepository.findById(entryId)
                .orElseThrow(() -> new AutomationException("Entry not found"));
        String[] parts = entry.split(",");
        entryToUpdate.setPolish(parts[0]);
        entryToUpdate.setEnglish(parts[1]);
        entryToUpdate.setGerman(parts[2]);
        entryAutomationRepository.save(entryToUpdate);
    }
}
