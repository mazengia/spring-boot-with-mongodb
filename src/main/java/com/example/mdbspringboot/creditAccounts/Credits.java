package com.example.mdbspringboot.creditAccounts;

import com.example.mdbspringboot.Grocery.GroceryItem;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Credits")
@Data
public class Credits {
    @Id
    private String id;
    private String name;
    private GroceryItem groceryItem;
}
