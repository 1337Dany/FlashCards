package org.example.flashcards.domain;

import org.example.flashcards.data.RepositoryContract;
import org.example.flashcards.ui.ViewContract;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class FlashCardsController {
    private ViewContract viewContract;
    private RepositoryContract repositoryContract;

    public FlashCardsController(ConfigurableApplicationContext context) {
        this.viewContract = context.getBean(ViewContract.class);
        this.repositoryContract = context.getBean(RepositoryContract.class);
    }



}
