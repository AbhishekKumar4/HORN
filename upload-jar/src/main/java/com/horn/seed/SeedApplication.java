package com.horn.seed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Abhishek
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.horn.seed.upload.config", "com.horn.seed.upload"})
public class SeedApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeedApplication.class, args);
	}
}
