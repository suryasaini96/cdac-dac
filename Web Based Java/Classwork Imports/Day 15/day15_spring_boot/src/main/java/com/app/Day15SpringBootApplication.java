package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "com.app")
//@EntityScan(basePackages = "com.app")
public class Day15SpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(Day15SpringBootApplication.class, args);
	}

}
