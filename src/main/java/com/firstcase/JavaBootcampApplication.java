package com.firstcase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan(basePackages = {"com.firstcase.javabootcamp.*"})
@EnableAutoConfiguration
@Configuration
public class JavaBootcampApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaBootcampApplication.class, args);
	}
	
	

}
