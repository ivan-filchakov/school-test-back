package com.example.school_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication 
@SpringBootApplication(exclude = { 
    org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class 
})
public class SchoolTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolTestApplication.class, args);
	}

}
