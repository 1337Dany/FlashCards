package org.example.flashcardsrebased.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Setter;

@Setter
@Entity
public class Entry {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    private String polish;
    private String english;
    private String german;

    public Entry(String polish, String english, String german) {
        this.polish = polish;
        this.english = english;
        this.german = german;
    }

    protected Entry() {
    } // for JPA only

    public long id() {
        return id;
    }

    public String polish() {
        return polish;
    }

    public String english() {
        return english;
    }

    public String german() {
        return german;
    }

    @Override
    public String toString() {
        return String.format("| %-10s | %-15s | %-15s | %-15s |\n",
                id, polish, english, german);
    }
}