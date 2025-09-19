package com.prelim.exam;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CredentialsDisplay implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\nLogin: admin / admin123");
        System.out.println("URL: http://localhost:8080\n");
    }
}
