package com.neon.academy.openapi;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.neon.academy.openapi.reverse.AnimalR;

@Controller
public class AnimalsControllerR implements AnimalsApiR{
  @Override
  public ResponseEntity<String> addAnimal(AnimalR animal) {
    return null;
  }
}
