package org.example.flashcardsrebased.ui.profiles.formatters;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("lowercase")
public class LowerCaseFormatter implements EntryFormatter {

    @Override
    public String format(String entry) {
        return entry.toLowerCase();
    }
}
