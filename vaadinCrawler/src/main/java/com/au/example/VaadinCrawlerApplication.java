package com.au.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.au.example.model.User;
import com.au.example.repo.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@ComponentScan(basePackages="com.au.example")
public class VaadinCrawlerApplication {

	private static final Logger log = LoggerFactory.getLogger(VaadinCrawlerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(VaadinCrawlerApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(UserRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new User("Ayhan", "Ugurlu", "1"));
			repository.save(new User("admin", "admin", "1"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (User customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			User customer = repository.findOne(1L);
			log.info("Customer found with findOne(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastNameStartsWithIgnoreCase('Bauer'):");
			log.info("--------------------------------------------");
			for (User bauer : repository.findByLastNameStartsWithIgnoreCase("Ugurlu")) {
				log.info(bauer.toString());
			}
			log.info("");
		};
	}
}
