package com.example.hospitaldatabase.UserContactForm;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;


@Configuration
public class MailConfig {

    @Value("${spring.mail.host}")
    private String host;

    @Value("${spring.mail.port}")
    private int port;

    @Value("${spring.mail.default-encoding}")
    private String encoding;

    @Value("${spring.mail.properties.mail.debug}")
    private String debug;
    
    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setDefaultEncoding(encoding);
        mailSender.setHost(host);
        mailSender.setPort(port);

     
        Properties properties = new Properties();
        properties.put("mail.debug", debug);
        mailSender.setJavaMailProperties(properties);

        return mailSender;
    }

}