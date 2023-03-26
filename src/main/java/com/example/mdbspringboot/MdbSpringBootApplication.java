package com.example.mdbspringboot;


import com.example.mdbspringboot.creditAccounts.CreditsRepository;
import com.example.mdbspringboot.Grocery.CustomItemRepository;
import com.example.mdbspringboot.Grocery.GroceryItem;
import com.example.mdbspringboot.Grocery.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableMongoRepositories
@RequiredArgsConstructor

//public class MdbSpringBootApplication{
//    public static void main(String[] args) {
//        SpringApplication.run(MdbSpringBootApplication.class, args);
//    }
//}
public class MdbSpringBootApplication implements CommandLineRunner {
    private final ItemRepository groceryItemRepo;
    private final CreditsRepository creditsRepository;
    private final CustomItemRepository customRepo;

    List<GroceryItem> itemList = new ArrayList<GroceryItem>();

    public static void main(String[] args) {
        SpringApplication.run(MdbSpringBootApplication.class, args);
    }

    public void run(String... args) {
        groceryItemRepo.deleteAll(); // Doesn't delete the collection
        createGroceryItems();
        showAllGroceryItems();
        getGroceryItemByName("Whole Wheat Biscuit");
        getItemsByCategory("millets");
        updateCategoryName("snacks");
        updateItemQuantity("Bonny Cheese Crackers Plain", 10);
        deleteGroceryItem("Kodo Millet");
        findCountOfGroceryItems();
    }
    void createGroceryItems() {
        System.out.println("Data creation started...");
        GroceryItem groceryItem = new GroceryItem();
        groceryItem.setId("Whole Wheat Biscuit");
        groceryItem.setName("Whole Wheat Biscuit");
        groceryItem.setQuantity(5);
        groceryItem.setCategory("snacks");
        groceryItemRepo.save(groceryItem);
        groceryItem.setId("Kodo Millet");
        groceryItem.setName("XYZ Kodo Millet healthy");
        groceryItem.setQuantity(2);
        groceryItem.setCategory("millets");
        groceryItemRepo.save(groceryItem);
        groceryItem.setId("Dried Red Chilli");
        groceryItem.setName("Dried Whole Red Chilli");
        groceryItem.setQuantity(2);
        groceryItem.setCategory("spices");
        groceryItemRepo.save(groceryItem);

        groceryItem.setId("Pearl Millet");
        groceryItem.setName("Healthy Pearl Millet");
        groceryItem.setQuantity(1);
        groceryItem.setCategory("millets");
        groceryItemRepo.save(groceryItem);
        groceryItem.setId("Cheese Crackers");
        groceryItem.setName("Bonny Cheese Crackers Plain");
        groceryItem.setQuantity(6);
        groceryItem.setCategory("snacks");
        groceryItemRepo.save(groceryItem);


//        Credits credits = new Credits();
//        credits.setId("2");
//        credits.setName("mzze");
//        creditsRepository.save(credits);
//        System.out.println(credits);
        System.out.println("Data creation complete...");
    }

    // READ
    // 1. Show all the data
    public void showAllGroceryItems() {

        itemList = groceryItemRepo.findAll();

        itemList.forEach(item -> System.out.println(getItemDetails(item)));
    }

    // 2. Get item by name
    public void getGroceryItemByName(String name) {
        System.out.println("Getting item by name: " + name);
        GroceryItem item = groceryItemRepo.findItemByName(name);
        System.out.println(getItemDetails(item));
    }

    // 3. Get name and items of a all items of a particular category
    public void getItemsByCategory(String category) {
        System.out.println("Getting items for the category " + category);
        List<GroceryItem> list = groceryItemRepo.findAll(category);

        list.forEach(item -> System.out.println("Name: " + item.getName() + ", Quantity: " + item.getQuantity()));
    }

    public void findCountOfGroceryItems() {
        long count = groceryItemRepo.count();
        System.out.println("Number of documents in the collection = " + count);
    }

    // UPDATE APPROACH 1: Using MongoRepository
    public void updateCategoryName(String category) {
        String newCategory = "munchies";
        List<GroceryItem> list = groceryItemRepo.findAll(category);

        list.forEach(item -> {
            item.setCategory(newCategory);
        });
        List<GroceryItem> itemsUpdated = groceryItemRepo.saveAll(list);

        if (itemsUpdated != null)
            System.out.println("Successfully updated " + itemsUpdated.size() + " items.");
    }


    public void updateItemQuantity(String name, float newQuantity) {
        System.out.println("Updating quantity for " + name);
        customRepo.updateItemQuantity(name, newQuantity);
    }

    // DELETE
    public void deleteGroceryItem(String id) {
        groceryItemRepo.deleteById(id);
        System.out.println("Item with id " + id + " deleted...");
    }

    public String getItemDetails(GroceryItem item) {

        System.out.println(
                "Item Name: " + item.getName() +
                        ", \nItem Quantity: " + item.getQuantity() +
                        ", \nItem Category: " + item.getCategory()
        );

        return "";
    }
}

