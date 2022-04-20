package com.neon.academy.openapi;

import static java.lang.Math.max;
import static java.lang.Math.min;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.neon.academy.openapi.zoo.api.AnimalsApiDelegate;
import com.neon.academy.openapi.zoo.model.AnimalIndividualDto;
import com.neon.academy.openapi.zoo.model.InlineResponse201Dto;
import com.neon.academy.openapi.zoo.model.PagedAnimalsDto;
import com.neon.academy.openapi.zoo.model.PagingDto;

public class AnimalsController implements AnimalsApiDelegate {

  private final Map<String, AnimalIndividualDto> inMemoryDatabase;

  public AnimalsController() {
    this.inMemoryDatabase = new HashMap<>();
  }

  @Override
  public ResponseEntity<InlineResponse201Dto> addAnimal(AnimalIndividualDto animalIndividualDto) {
    final UUID uuid = UUID.randomUUID();
    final String id = uuid.toString();
    animalIndividualDto.setId(id);
    inMemoryDatabase.put(id, animalIndividualDto);
    return new ResponseEntity<>(new InlineResponse201Dto().id(id), HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<PagedAnimalsDto> getAllAnimals(Integer page, Integer pageSize) {
    if(page == null) page = 1;
    if(pageSize == null) pageSize = 10;
    final List<AnimalIndividualDto> animals = new ArrayList<>(inMemoryDatabase.values());
    int from = (page - 1) * pageSize;
    int to = min(page*pageSize, animals.size());
    final List<AnimalIndividualDto> pageOfAnimals = from < animals.size() ? animals.subList(from, to) : Collections.emptyList();
    final PagedAnimalsDto pagedAnimals = new PagedAnimalsDto()
      .animals(pageOfAnimals)
      .paging(new PagingDto().page(page).pageSize(pageSize));
    return new ResponseEntity<>(pagedAnimals, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<AnimalIndividualDto> getAnimal(String id) {
    final AnimalIndividualDto animal = inMemoryDatabase.get(id);
    if(animal == null){
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(animal, HttpStatus.OK); //todo etag
  }

  @Override
  public ResponseEntity<Void> removeAnimal(String id) {
    if(inMemoryDatabase.containsKey(id)){
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    inMemoryDatabase.remove(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<AnimalIndividualDto> updateAnimal(String id, String ifMatch, AnimalIndividualDto animalIndividualDto) {
    if(inMemoryDatabase.containsKey(id)){
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    inMemoryDatabase.put(id, animalIndividualDto);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
