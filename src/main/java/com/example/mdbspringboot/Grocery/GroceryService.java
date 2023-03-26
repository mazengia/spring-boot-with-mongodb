package com.example.mdbspringboot.Grocery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface GroceryService {
    GroceryItem createNewAccounts(GroceryItem groceryItem);
    Optional<GroceryItem> getNewAccountsById(String id);
    GroceryItem updateNewAccounts(String id, GroceryItem groceryItem
    ) throws IllegalAccessException;
    Page<GroceryItem> getAllNewAccounts(Pageable pageable
    );
    void deleteNewAccountsById(String id);

}
