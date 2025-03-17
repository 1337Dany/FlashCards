package org.example.flashcards.data;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class FileService implements IFileService {
    private final String filename;
    private final IEntryRepository entryRepository;

    public FileService(String filename, IEntryRepository entryRepository) {
        this.filename = filename;
        this.entryRepository = entryRepository;
    }

    @Override
    public void loadData() {
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String line;
            while((line = reader.readLine()) != null){
                String[] parts = line.split(",");
                entryRepository.add(new Entry(parts[0], parts[1], parts[2]));
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveData(IEntry entry) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(entry.getPolish() + "," + entry.getEnglish() + "," + entry.getGerman());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
