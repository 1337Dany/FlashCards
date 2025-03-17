package org.example.flashcards.ui.profiles.configs;

import org.example.flashcards.ui.profiles.formatters.EntryFormatter;
import org.example.flashcards.ui.profiles.formatters.UpperCaseFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("uppercase")
public class UppercaseProfileConfig {
    @Bean
    public EntryFormatter entryFormatter() {
        return new UpperCaseFormatter();
    }
}
