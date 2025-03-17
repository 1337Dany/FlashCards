package org.example.flashcards.data;

public class Entry implements IEntry {
    private String polish;
    private String english;
    private String german;

    public Entry(String polish, String english, String german) {
        this.polish = polish;
        this.english = english;
        this.german = german;
    }

    @Override
    public String getPolish() {
        return polish;
    }

    @Override
    public String getEnglish() {
        return english;
    }

    @Override
    public String getGerman() {
        return german;
    }
}
