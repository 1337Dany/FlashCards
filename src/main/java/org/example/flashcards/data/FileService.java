package org.example.flashcards.data;

import jakarta.annotation.PostConstruct;
import org.example.flashcards.ui.profiles.formatters.EntryFormatter;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class FileService implements IFileService, FileServiceDependency{
    private final String filename;
    private final IEntryRepository entryRepository;
    private final EntryFormatter entryFormatter;

    public FileService(String filename, IEntryRepository entryRepository, EntryFormatter entryFormatter) {
        this.filename = filename;
        this.entryRepository = entryRepository;
        this.entryFormatter = entryFormatter;
    }

    @PostConstruct
    @Override
    public void loadData() {
        System.out.println(filename);
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
            reader.readLine(); // skip the first line
            String line;
            while((line = reader.readLine()) != null){
                String[] parts = entryFormatter.format(line).split(",");
                entryRepository.add(new Entry(parts[0], parts[1], parts[2]));
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveData(Entry entry) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(entry.polish() + "," + entry.english() + "," + entry.german());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(String entry) {
        String[] parts = entryFormatter.format(entry).split(",");
        Entry tmp = new Entry(parts[0], parts[1], parts[2]);
        entryRepository.add(tmp);
        saveData(tmp);
    }
}
