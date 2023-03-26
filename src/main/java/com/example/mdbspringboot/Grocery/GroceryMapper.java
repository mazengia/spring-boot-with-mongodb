package com.example.mdbspringboot.Grocery;

import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface GroceryMapper {
    GroceryItem toGroceryItem(GroceryDto groceryDto);

    GroceryDto toGroceryDto(GroceryItem groceryItem);

    GroceryDto toGetGroceryDto(Optional<GroceryItem> groceryItem);
}
