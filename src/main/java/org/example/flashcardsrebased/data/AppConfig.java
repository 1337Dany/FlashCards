package org.example.flashcardsrebased.data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:dictionary.yml")
@ConfigurationProperties(prefix = "pl.edu.pja.tpo02")
public class AppConfig {

    @Value("${filename}")
    private String filename;

    @Bean
    public String fileName() {
        return filename;
        }
}
