package org.example.flashcards.data;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class FileService implements IFileService {
    private IEntryRepository entryRepository;

    public FileService(){
        loadData();
    }

    @PostConstruct
    @Override
    public void loadData() {

    }
}
