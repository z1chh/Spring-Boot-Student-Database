package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository pRepository) {
        return args -> {
            Student fei = new Student(
                    1L,
                    "Fei",
                    "fei@gmail.com",
                    LocalDate.of(2002, Month.SEPTEMBER, 8)
            );

            Student zichh = new Student(
                    "Zichh",
                    "zichh@gmail.com",
                    LocalDate.of(1999, Month.DECEMBER, 3)
            );

            pRepository.saveAll(
                    List.of(fei, zichh)
            );
        };
    }
}
