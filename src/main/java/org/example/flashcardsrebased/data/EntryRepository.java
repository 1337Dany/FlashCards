package org.example.flashcardsrebased.data;

import jakarta.persistence.EntityManager;
import org.example.flashcardsrebased.ui.profiles.formatters.EntryFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Repository
public class EntryRepository implements RepositoryContract {
    private final EntityManager entityManager;
    private final EntryFormatter entryFormatter;

    @Autowired
    public EntryRepository(EntityManager entityManager, EntryFormatter entryFormatter) {
        this.entityManager = entityManager;
        this.entryFormatter = entryFormatter;
    }

    @Transactional
    @Override
    public String displayAll() {
        String allEntries = "";
        allEntries = entityManager.createQuery("SELECT e FROM Entry e", Entry.class).getResultList().toString();
        return entryFormatter.format(allEntries);
    }

    @Transactional
    @Override
    public void add(String entry) {
       String[] parts = entry.split(",");
        Entry tmp = new Entry(parts[0], parts[1], parts[2]);
        entityManager.persist(tmp);
    }

    @Transactional
    @Override
    public Entry getRandomEntry() {
        List<Long> ids = entityManager.createQuery("SELECT e.id FROM Entry e", Long.class).getResultList();
        if (ids.isEmpty()) {
            return null; // или выбросить исключение, если нет записей
        }
        Random random = new Random();
        Long randomId = ids.get(random.nextInt(ids.size()));
        return entityManager.find(Entry.class, randomId);
    }
}
