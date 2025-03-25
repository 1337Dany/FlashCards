package org.example.flashcardsrebased.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EntryAutomationRepository extends JpaRepository<Entry, Long> {
    @Query("SELECT e FROM Entry e WHERE e.polish LIKE %:regex% OR e.english LIKE %:regex% OR e.german LIKE %:regex%")
    Entry findByRegex(@Param("regex") String regex);

    List<Entry> findAllByOrderByEnglishAsc();
    List<Entry> findAllByOrderByPolishAsc();
    List<Entry> findAllByOrderByGermanAsc();
    List<Entry> findAllByOrderByEnglishDesc();
    List<Entry> findAllByOrderByPolishDesc();
    List<Entry> findAllByOrderByGermanDesc();
}
