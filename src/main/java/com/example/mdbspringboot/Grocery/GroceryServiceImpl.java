package com.example.mdbspringboot.Grocery;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroceryServiceImpl implements GroceryService {

    private final ItemRepository itemRepository;


    @Override
    public GroceryItem createNewAccounts(GroceryItem groceryItem) {
        return   itemRepository.save(groceryItem);
    }



    @Override
    public Optional<GroceryItem> getNewAccountsById(String id) {
        return itemRepository.findByQuantity(id);
    }

    @Override
    public GroceryItem updateNewAccounts(String id, GroceryItem groceryItem) throws IllegalAccessException {
      return  itemRepository.save(groceryItem);

    }

    @Override
    public Page<GroceryItem> getAllNewAccounts(Pageable pageable
    ) {
        return itemRepository.findAll(pageable);
    }

    @Override
    public void deleteNewAccountsById(String id) {
        itemRepository.deleteById(id);
    }

}
