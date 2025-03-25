package org.example.flashcardsrebased.domain;

import org.example.flashcardsrebased.data.Entry;
import org.example.flashcardsrebased.data.RepositoryContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class FlashCardsController implements ControllerContract {
    private final RepositoryContract repositoryContract;

    @Autowired
    public FlashCardsController(RepositoryContract repositoryContract) {
        this.repositoryContract = repositoryContract;
    }

    @Override
    public String displayAll() {
        return repositoryContract.displayAll();
    }

    @Override
    public void add(String entry) {
        repositoryContract.add(entry);
    }

    @Override
    public Entry getRandomEntry() {
        return repositoryContract.getRandomEntry();
    }

    @Override
    public void delete(long entryId) {
        repositoryContract.delete(entryId);
    }

    @Override
    public void modify(long entryId, String entry) {
        repositoryContract.modify(entryId, entry);
    }
}
