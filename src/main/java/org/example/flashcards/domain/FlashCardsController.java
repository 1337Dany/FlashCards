package org.example.flashcards.domain;

import org.example.flashcards.data.Entry;
import org.example.flashcards.data.FileServiceDependency;
import org.example.flashcards.data.RepositoryContract;
import org.example.flashcards.data.RepositoryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class FlashCardsController implements ControllerContract {
    private final RepositoryManager repositoryManager;

    @Autowired
    public FlashCardsController(RepositoryManager repositoryManager) {
        this.repositoryManager = repositoryManager;
    }


    @Override
    public String displayAll() {
        return repositoryManager.displayAll();
    }

    @Override
    public void add(String entry) {
        repositoryManager.add(entry);
    }

    @Override
    public Entry getRandomEntry() {
        return repositoryManager.getRandomEntry();
    }
}
