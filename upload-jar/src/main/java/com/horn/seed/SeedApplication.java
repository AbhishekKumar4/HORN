package com.horn.seed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Abhishek
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = { "com.horn.seed.upload.service.impl", "com.horn.seed.upload.controller" })
public class SeedApplication {

	/*
	 * @Bean public ServletRegistrationBean h2servletRegistration() {
	 * ServletRegistrationBean registration = new ServletRegistrationBean(new
	 * WebServlet()); registration.addUrlMappings("/console/*"); return
	 * registration; }
	 */
	public static void main(String[] args) {
		SpringApplication.run(SeedApplication.class, args);
	}
}
