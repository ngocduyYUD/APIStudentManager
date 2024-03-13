package com.webapi.StudentsManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class StudentsManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentsManagerApplication.class, args);
	}

}
