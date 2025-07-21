package com.foodie.backend.repository;

import com.foodie.backend.model.Order;
import com.foodie.backend.model.OrderStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
    List<Order> findByUserId(String userId);
    List<Order> findByRestaurantId(String restaurantId);
    List<Order> findByStatus(OrderStatus status);
    List<Order> findByUserIdAndStatus(String userId, OrderStatus status);
}
