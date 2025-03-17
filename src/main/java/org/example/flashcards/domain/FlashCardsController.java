package org.example.flashcards.domain;

import org.example.flashcards.data.Entry;
import org.example.flashcards.data.FileServiceDependency;
import org.example.flashcards.data.RepositoryContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlashCardsController implements ControllerContract {
    private final RepositoryContract repositoryContract;
    private final FileServiceDependency fileServiceDependency;

    @Autowired
    public FlashCardsController(RepositoryContract repositoryContract, FileServiceDependency fileServiceDependency) {
        this.repositoryContract = repositoryContract;
        this.fileServiceDependency = fileServiceDependency;
    }


    @Override
    public String displayAll() {
        return repositoryContract.displayAll();
    }

    @Override
    public void add(String entry) {
        fileServiceDependency.add(entry);
    }

    @Override
    public Entry getRandomEntry() {
        return repositoryContract.getRandomEntry();
    }
}
