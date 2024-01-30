package com.nhnacademy.edu.springframework.messagesender.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.nhnacademy.edu.springframework.messagesender")
@PropertySource("sender.properties")
public class MainConfig {
    // empty
}
