package com.example.mdbspringboot.creditAccounts;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CreditsServiceImpl implements CreditsService {

    private final CreditsRepository creditsRepository;


    @Override
    public Credits createNewAccounts(Credits intervenes) {
        return   creditsRepository.save(intervenes);
    }



    @Override
    public Optional<Credits> getNewAccountsById(String id) {
        return creditsRepository.findById(id);
    }

    @Override
    public Credits updateNewAccounts(String id, Credits credits) throws IllegalAccessException {
      return  creditsRepository.save(credits);

    }

    @Override
    public Page<Credits> getAllNewAccounts(Pageable pageable
    ) {
        return creditsRepository.findAll(pageable);
    }

    @Override
    public void deleteNewAccountsById(String id) {
        creditsRepository.deleteById(id);
    }

}
