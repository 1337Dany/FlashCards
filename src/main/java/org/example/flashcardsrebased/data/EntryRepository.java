package org.example.flashcardsrebased.data;

import jakarta.persistence.EntityManager;
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
        String allEntries = "";
        allEntries += entryAutomationRepository.findAll().toString();
        return entryFormatter.format(allEntries);
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
        List<Long> ids = entryAutomationRepository.findAllEntryId();
        if (ids.isEmpty()) {
            return null; // или выбросить исключение, если нет записей
        }
        Random random = new Random();
        Long randomId = ids.get(random.nextInt(ids.size()));
        return entryAutomationRepository.findById(randomId).orElseThrow();
    }

    @Transactional
    @Override
    public void delete(long entryId) {
        Entry entry = entryAutomationRepository.findById(entryId).orElseThrow();
        entryAutomationRepository.delete(entry);
    }

    @Transactional
    @Override
    public void modify(long entryId, String entry) {
        Entry entryToUpdate = entryAutomationRepository.findById(entryId).orElseThrow();
        entryAutomationRepository.delete(entryToUpdate);

        String[] parts = entry.split(",");

        entryAutomationRepository.save(new Entry(parts[0], parts[1], parts[2]));
    }
}
