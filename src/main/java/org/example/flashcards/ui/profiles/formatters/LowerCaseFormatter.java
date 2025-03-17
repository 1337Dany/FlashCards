package org.example.flashcards.ui.profiles.formatters;

import org.example.flashcards.data.Entry;

public class LowerCaseFormatter implements EntryFormatter{
    @Override
    public Entry format(Entry entry) {
        return new Entry(entry.polish().toLowerCase(), entry.english().toLowerCase(), entry.german().toLowerCase());
    }
}
