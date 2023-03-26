package com.example.mdbspringboot.Grocery;

import com.example.mdbspringboot.util.PaginatedResultsRetrievedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/v1/grocery")
@RequiredArgsConstructor
public class GroceryController implements GroceryApi {
    private final GroceryService groceryService;
    private final GroceryMapper groceryMapper;
    private final ApplicationEventPublisher eventPublisher;

    @Override
    public GroceryDto createIntervenes(
            GroceryDto groceryDto
    )
            throws IllegalAccessException {
        return groceryMapper.toGroceryDto(
                groceryService.createNewAccounts(
                        groceryMapper.toGroceryItem(groceryDto)
                ));
    }


    @Override
    public GroceryDto getIntervene(String id) {
        return groceryMapper.toGetGroceryDto(groceryService.getNewAccountsById(id));
    }

    @Override
    public void deleteIntervene(String id) {
        groceryService.deleteNewAccountsById(id);
    }

    @Override
    public GroceryDto updateIntervene(String id, GroceryDto groceryDto
    ) throws IllegalAccessException {
        return groceryMapper.toGroceryDto(groceryService.updateNewAccounts(id, groceryMapper.toGroceryItem(groceryDto)

        ));
    }

    @Override
    public ResponseEntity<PagedModel<GroceryDto>> getIntervenes(Pageable pageable, PagedResourcesAssembler assembler

            , UriComponentsBuilder uriBuilder) {
        eventPublisher.publishEvent(new PaginatedResultsRetrievedEvent<>(
                GroceryDto.class, uriBuilder, pageable.getPageNumber(), groceryService.getAllNewAccounts(pageable

        ).getTotalPages(), pageable.getPageSize()));
        return new ResponseEntity<PagedModel<GroceryDto>>(assembler.toModel(groceryService.getAllNewAccounts(pageable

        ).map(groceryMapper::toGroceryDto)), HttpStatus.OK);
    }
}
