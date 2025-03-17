package org.example.flashcards.ui.profiles.formatters;

import org.example.flashcards.data.Entry;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("lowercase")
public class LowerCaseFormatter implements EntryFormatter {

    @Override
    public Entry format(Entry entry) {
        return new Entry(entry.polish().toLowerCase(), entry.english().toLowerCase(), entry.german().toLowerCase());
    }
}
