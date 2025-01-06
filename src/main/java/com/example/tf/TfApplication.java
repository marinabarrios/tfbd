package com.example.tf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class TfApplication {

	public static void main(String[] args) {
		SpringApplication.run(TfApplication.class, args);
	}

	@PostConstruct
	public void logDatabaseConfig() {
		System.out.println("Datasource URL: " + System.getProperty("spring.datasource.url"));
	}
}
