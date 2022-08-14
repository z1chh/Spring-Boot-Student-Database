package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Zichh
 * Basic student database implemented using Spring Boot.
 * Allows user to add students, remove students or change information.
 * Student IDs and emails are unique.
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
