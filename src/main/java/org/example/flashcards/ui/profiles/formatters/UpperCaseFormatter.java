package org.example.flashcards.ui.profiles.formatters;

import org.example.flashcards.data.Entry;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("uppercase")
public class UpperCaseFormatter implements EntryFormatter {
    @Override
    public String format(String entry) {
        return entry.toUpperCase();
    }
}
