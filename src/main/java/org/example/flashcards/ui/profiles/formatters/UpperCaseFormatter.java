package org.example.flashcards.ui.profiles.formatters;

import org.example.flashcards.data.Entry;

public class UpperCaseFormatter implements EntryFormatter{
    @Override
    public Entry format(Entry entry) {
        return new Entry(entry.polish().toUpperCase(), entry.english().toUpperCase(), entry.german().toUpperCase());
    }
}
