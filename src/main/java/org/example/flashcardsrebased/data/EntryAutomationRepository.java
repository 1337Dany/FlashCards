package org.example.flashcardsrebased.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EntryAutomationRepository extends JpaRepository<Entry, Long> {
    List<Long> findAllEntryId();
}
