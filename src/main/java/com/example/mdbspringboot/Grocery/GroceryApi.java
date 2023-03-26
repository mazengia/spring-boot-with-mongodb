package com.example.mdbspringboot.Grocery;


import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


public interface GroceryApi {

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    GroceryDto createIntervenes(@RequestBody   GroceryDto groceryDto ) throws IllegalAccessException;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    GroceryDto getIntervene(@PathVariable("id") String id);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteIntervene(@PathVariable("id") String id);

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    GroceryDto updateIntervene(@PathVariable("id") String id, @RequestBody   GroceryDto groceryDto
    ) throws IllegalAccessException;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<PagedModel<GroceryDto>> getIntervenes(@Parameter(description = "pagination object",
            schema = @Schema(implementation = Pageable.class))
                                                                 Pageable pageable,
                                                         PagedResourcesAssembler assembler,
                                                         UriComponentsBuilder uriBuilder );
}
