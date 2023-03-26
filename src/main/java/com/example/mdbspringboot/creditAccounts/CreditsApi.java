package com.example.mdbspringboot.creditAccounts;


import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


public interface CreditsApi {

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    CreditsDto createIntervenes(@RequestBody   CreditsDto creditsDtos ) throws IllegalAccessException;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
     CreditsDto getIntervene(@PathVariable("id") String id);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteIntervene(@PathVariable("id") String id);

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    CreditsDto updateIntervene(@PathVariable("id") String id, @RequestBody   CreditsDto creditsDto
    ) throws IllegalAccessException;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<PagedModel<CreditsDto>> getIntervenes(@Parameter(description = "pagination object",
            schema = @Schema(implementation = Pageable.class))
                                                                 Pageable pageable,
                                                         PagedResourcesAssembler assembler,
                                                         UriComponentsBuilder uriBuilder );
}
