package org.example.flashcards.data;

import org.springframework.stereotype.Component;

@Component
public class RepositoryManager {
    private final RepositoryContract repositoryContract;
    private final FileServiceDependency fileServiceDependency;

    public RepositoryManager(RepositoryContract repositoryContract, FileServiceDependency fileServiceDependency) {
        this.repositoryContract = repositoryContract;
        this.fileServiceDependency = fileServiceDependency;
    }

    public String displayAll() {
        return repositoryContract.displayAll();
    }

    public void add(String entry) {
        fileServiceDependency.add(entry);
    }

    public Entry getRandomEntry() {
        return repositoryContract.getRandomEntry();
    }
}
