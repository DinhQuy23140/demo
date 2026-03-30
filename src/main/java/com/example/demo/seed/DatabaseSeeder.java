package com.example.demo.seed;

import com.example.demo.assignment.seed.AcademySeeder;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DatabaseSeeder implements CommandLineRunner {
    private final AcademySeeder academySeeder;

    @Override
    public void run(String... args) throws Exception {
        academySeeder.seed();
    }
}
