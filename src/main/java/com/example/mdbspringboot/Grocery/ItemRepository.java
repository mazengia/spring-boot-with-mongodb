package com.example.mdbspringboot.Grocery;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends MongoRepository<GroceryItem, String> {

	@Query("{name:'?0'}")
	GroceryItem findItemByName(String name);

	@Query(value="{category:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
	List<GroceryItem> findAll(String category);

	public long count();
	@Query("{quantity:'?0'}")
    Optional<GroceryItem> findByQuantity(String quantity);
}
