package com.neon.academy.openapi;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.neon.academy.openapi.reverse.AnimalR;
import com.neon.academy.openapi.zoo.model.AnimalIndividualDto;
import com.neon.academy.openapi.zoo.model.InlineResponse201Dto;
import com.neon.academy.openapi.zoo.model.PagedAnimalsDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

public interface AnimalsApiR {
  @Operation(
    summary = "Add an animal",
    responses = {
      @ApiResponse(responseCode = "201", description = "Animal Added")
    },
    security = {
      @SecurityRequirement(name = "basicAuthR"),
      @SecurityRequirement(name = "oauth2R", scopes={ "list:animal" })
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
