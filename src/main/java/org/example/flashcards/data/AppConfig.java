package org.example.flashcards.data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.yml")
public class AppConfig {

    @Value("${pl.edu.pja.tpo02.filename}")
    private String filename;

    @Bean
    public String fileService() {
        return filename;
        }
}
