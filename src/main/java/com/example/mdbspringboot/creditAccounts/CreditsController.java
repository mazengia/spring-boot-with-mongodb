package com.example.mdbspringboot.creditAccounts;

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
@RequestMapping("/api/v1/new-account")
@RequiredArgsConstructor
public class CreditsController implements CreditsApi {
    private final CreditsRepository creditsRepository;
    private final CreditsService creditsService;
    private final CreditsMapper creditsMapper;
    private final ApplicationEventPublisher eventPublisher;

    @Override
    public CreditsDto createIntervenes(
            CreditsDto creditsDtos
    )
            throws IllegalAccessException {
        return creditsMapper.toInterveneDto(
                creditsService.createNewAccounts(
                        creditsMapper.toIntervene(creditsDtos)
                ));
    }


    @Override
    public CreditsDto getIntervene(String id) {
        return creditsMapper.toGetInterveneDto(creditsService.getNewAccountsById(id));
    }

    @Override
    public void deleteIntervene(String id) {
        creditsService.deleteNewAccountsById(id);
    }

    @Override
    public CreditsDto updateIntervene(String id, CreditsDto creditsDto
    ) throws IllegalAccessException {
        return creditsMapper.toInterveneDto(creditsService.updateNewAccounts(id, creditsMapper.toIntervene(creditsDto)

        ));
    }

    @Override
    public ResponseEntity<PagedModel<CreditsDto>> getIntervenes(Pageable pageable, PagedResourcesAssembler assembler

            , UriComponentsBuilder uriBuilder) {
        eventPublisher.publishEvent(new PaginatedResultsRetrievedEvent<>(
                CreditsDto.class, uriBuilder, pageable.getPageNumber(), creditsService.getAllNewAccounts(pageable

        ).getTotalPages(), pageable.getPageSize()));
        return new ResponseEntity<PagedModel<CreditsDto>>(assembler.toModel(creditsService.getAllNewAccounts(pageable

        ).map(creditsMapper::toInterveneDto)), HttpStatus.OK);
    }
}
