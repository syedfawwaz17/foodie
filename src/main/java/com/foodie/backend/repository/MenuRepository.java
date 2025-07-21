package com.foodie.backend.repository;

import com.foodie.backend.model.Menu;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends MongoRepository<Menu, String> {
    List<Menu> findByRestaurantId(String restaurantId);
    long countByRestaurantId(String restaurantId);
    void deleteByRestaurantId(String restaurantId);



}