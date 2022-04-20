package com.neon.academy.openapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.neon.academy.openapi.zoo.api.AnimalsApiDelegate;

@SpringBootApplication
public class OpenapiApplication {

	@Bean
	AnimalsApiDelegate animalsApiDelegate(){
		return new AnimalsController();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(OpenapiApplication.class, args);
	}
}
