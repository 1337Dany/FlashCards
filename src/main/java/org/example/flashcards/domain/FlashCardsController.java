package org.example.flashcards.domain;

import org.example.flashcards.data.Entry;
import org.example.flashcards.data.ServiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class FlashCardsController implements ControllerContract {
    private final ServiceManager serviceManager;

    @Autowired
    public FlashCardsController(ServiceManager serviceManager) {
        this.serviceManager = serviceManager;
    }


    @Override
    public String displayAll() {
        return serviceManager.displayAll();
    }

    @Override
    public void add(String entry) {
        serviceManager.add(entry);
    }

    @Override
    public Entry getRandomEntry() {
        return serviceManager.getRandomEntry();
    }
}
