package com.foodie.backend.repository;

import com.foodie.backend.model.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RestaurantRepository extends MongoRepository<Restaurant, String> {
    List<Restaurant> findByCuisineType(String cuisineType);
    List<Restaurant> findByNameContainingIgnoreCase(String name);
    List<Restaurant> findByAddressContainingIgnoreCase(String address);
}