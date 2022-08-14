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
            Student zichh = new Student(
                    "Zichh",
                    "huzichen@gmail.com",
                    LocalDate.of(1999, Month.DECEMBER, 3)
            );

            Student someone = new Student(
                    1L,
                    "Someone",
                    "someone@gmail.com",
                    LocalDate.of(2002, Month.SEPTEMBER, 8)
            );

            Student first = new Student(
                    1L,
                    "First",
                    "first@gmail.com",
                    LocalDate.of(2021, Month.NOVEMBER, 27)
            );

            Student meet = new Student(
                    1L,
                    "Meet",
                    "meet@gmail.com",
                    LocalDate.of(2021, Month.OCTOBER, 21)
            );

            Student boaty = new Student(
                    1L,
                    "Boaty",
                    "boaty@gmail.com",
                    LocalDate.of(2022, Month.JULY, 15)
            );

            Student cheerleaderBear = new Student(
                    1L,
                    "Cheerleader Bear",
                    "cheerleaderbear@gmail.com",
                    LocalDate.of(2022, Month.JULY, 15)
            );

            pRepository.saveAll(
                    List.of(zichh, someone, first, meet, boaty, cheerleaderBear)
            );
        };
    }
}
