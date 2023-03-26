package com.example.mdbspringboot.Grocery;

import com.example.mdbspringboot.creditAccounts.Credits;
import lombok.Data;

import java.util.List;

@Data
public class GroceryDto {
    private String id;
    private String name;
    private int quantity;
    private String category;
    List<Credits> credits;
}
