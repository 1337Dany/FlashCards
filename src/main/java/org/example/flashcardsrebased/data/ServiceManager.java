package org.example.flashcardsrebased.data;

import org.springframework.stereotype.Service;

@Service
public class ServiceManager {
    private final RepositoryContract repositoryContract;
    private final FileServiceDependency fileServiceDependency;

    public ServiceManager(RepositoryContract repositoryContract, FileServiceDependency fileServiceDependency) {
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
