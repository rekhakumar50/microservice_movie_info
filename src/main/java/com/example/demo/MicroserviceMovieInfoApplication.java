package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:movieInfo.properties")
public class MicroserviceMovieInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceMovieInfoApplication.class, args);
	}

}
