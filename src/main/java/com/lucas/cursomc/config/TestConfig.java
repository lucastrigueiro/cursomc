package com.lucas.cursomc.config;

import com.lucas.cursomc.services.DBService;
import com.lucas.cursomc.services.EmailService;
import com.lucas.cursomc.services.MockEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private DBService dbService;

    @Bean
    public boolean instantiateDatabase() throws ParseException {
        dbService.instantiateDatabase();
        return true;
    }

    @Bean
    public EmailService emailService(){
        return new MockEmailService();
    }
}
