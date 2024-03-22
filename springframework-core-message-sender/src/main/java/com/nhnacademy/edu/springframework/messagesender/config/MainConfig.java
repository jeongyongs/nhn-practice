package com.nhnacademy.edu.springframework.messagesender.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.nhnacademy.edu.springframework.messagesender")
@PropertySource("classpath:/sender.properties")
@EnableAspectJAutoProxy
public class MainConfig {
    // empty
}
