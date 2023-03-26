package com.example.mdbspringboot.Grocery;

import com.example.mdbspringboot.creditAccounts.Credits;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("GroceryItem")
@Data
public class GroceryItem {
    @Id
    private String id;
    private String name;
    private int quantity;
    private String category;
    @DBRef
    List<Credits> credits;
}
