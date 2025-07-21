package com.foodie.backend.repository;

import com.foodie.backend.model.MenuItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuItemRepository extends MongoRepository<MenuItem, String> {
    List<MenuItem> findByRestaurantId(String restaurantId);
    long countByRestaurantId(String restaurantId); // ✅ Properly named
}
