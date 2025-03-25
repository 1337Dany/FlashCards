package org.example.flashcardsrebased.domain;

import org.example.flashcardsrebased.data.Entry;
import org.example.flashcardsrebased.data.RepositoryContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
}
