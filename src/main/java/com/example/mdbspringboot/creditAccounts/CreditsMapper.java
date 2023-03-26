package com.example.mdbspringboot.creditAccounts;

import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface CreditsMapper {
    Credits toIntervene(CreditsDto creditsDto);

    CreditsDto toInterveneDto(Credits credits);

    CreditsDto toGetInterveneDto(Optional<Credits> credits);
}
