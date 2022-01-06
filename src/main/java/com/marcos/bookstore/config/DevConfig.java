package com.marcos.bookstore.config;

import com.marcos.bookstore.service.DBService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {
    
    @Autowired
    public DBService dbService;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    public String strategy;
}
