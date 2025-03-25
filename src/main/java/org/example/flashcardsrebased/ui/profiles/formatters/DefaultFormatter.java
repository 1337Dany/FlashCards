package org.example.flashcardsrebased.ui.profiles.formatters;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("default")
public class DefaultFormatter implements EntryFormatter{
    @Override
    public String format(String entry) {
        return entry;
    }
}
