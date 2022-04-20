package com.neon.academy.openapi.reverse;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

public interface AnimalsApiR {
  @Operation(
    summary = "Add an animal",
    responses = {
      @ApiResponse(responseCode = "201", description = "Animal Added")
    }
  )
  @RequestMapping(
    method = RequestMethod.POST,
    value = "/animals/",
    produces = { "application/json" },
    consumes = { "application/json" }
  )
  ResponseEntity<String> addAnimal(
    @Parameter(name = "AnimalIndividualDto", description = "") @Valid @RequestBody(required = false) AnimalR animal
  );

}
