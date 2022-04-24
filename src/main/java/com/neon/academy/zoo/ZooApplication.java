package com.neon.academy.zoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.neon.academy.openapi.zoo.api.AnimalsApi;
import com.neon.academy.openapi.zoo.api.AnimalsApiController;
import com.neon.academy.openapi.zoo.api.AnimalsApiDelegate;

@SpringBootApplication
@ComponentScan(basePackages = "com.neon.academy.openapi.zoo.api")
public class ZooApplication {

  @Bean
  AnimalsApiDelegate getAnimalController(){
    return new AnimalController();
  }

  public static void main(String[] args) {
    SpringApplication.run(ZooApplication.class, args);
  }

}
