package com.neon.academy.zoo;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.neon.academy.openapi.zoo.api.AnimalsApiDelegate;
import com.neon.academy.openapi.zoo.model.AnimalIndividualDto;
import com.neon.academy.openapi.zoo.model.InlineResponse201Dto;

public class AnimalController implements AnimalsApiDelegate {

  private final Map<String, AnimalIndividualDto> inMemoryDb = new HashMap<>();

  @Override
  public ResponseEntity<InlineResponse201Dto> addAnimal(AnimalIndividualDto animalIndividualDto) {
    final String id = UUID.randomUUID().toString();
    animalIndividualDto.setId(id);
    // 409
    inMemoryDb.put(id, animalIndividualDto);
    return new ResponseEntity<>(new InlineResponse201Dto().id(id), HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<AnimalIndividualDto> getAnimal(String id) {
    final AnimalIndividualDto animalIndividualDto = inMemoryDb.get(id);
    if(animalIndividualDto == null){
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(animalIndividualDto, HttpStatus.OK);
  }
}
