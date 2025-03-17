package org.example.flashcards.ui.profiles.formatters;

import org.example.flashcards.data.Entry;

public class DefaultFormatter implements EntryFormatter{
    @Override
    public Entry format(Entry entry) {
        return new Entry(entry.polish(), entry.english(), entry.german());
    }
}
