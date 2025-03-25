package org.example.flashcardsrebased.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryAutomationRepository extends JpaRepository<Entry, Long> {
    String findAllBy;

}
