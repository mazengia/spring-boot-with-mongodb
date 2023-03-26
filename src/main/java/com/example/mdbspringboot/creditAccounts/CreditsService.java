package com.example.mdbspringboot.creditAccounts;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface CreditsService {
    Credits createNewAccounts(Credits intervenes);
    Optional<Credits> getNewAccountsById(String id);
    Credits updateNewAccounts(String id, Credits credits
    ) throws IllegalAccessException;
    Page<Credits> getAllNewAccounts(Pageable pageable
    );
    void deleteNewAccountsById(String id);

}
