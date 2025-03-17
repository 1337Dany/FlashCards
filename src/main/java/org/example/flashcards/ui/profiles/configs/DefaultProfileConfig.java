package org.example.flashcards.ui.profiles.configs;

import org.example.flashcards.ui.profiles.formatters.DefaultFormatter;
import org.example.flashcards.ui.profiles.formatters.EntryFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("default")
public class DefaultProfileConfig {
    @Bean
    public EntryFormatter entryFormatter() {
        return new DefaultFormatter();
    }
}
