package com.neon.academy.openapi.reverse;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class AnimalsControllerR implements AnimalsApiR{
  @Override
  public ResponseEntity<String> addAnimal(AnimalR animal) {
    return null;
  }
}
