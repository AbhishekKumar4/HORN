package com.horn.seed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SeedApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeedApplication.class, args);
	}
}