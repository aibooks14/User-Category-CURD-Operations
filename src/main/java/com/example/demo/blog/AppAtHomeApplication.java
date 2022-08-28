package com.example.demo.blog;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppAtHomeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppAtHomeApplication.class, args);
	}
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper() ;
	}

}
