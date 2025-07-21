package com.foodie.backend.service;

import com.foodie.backend.dto.OrderDTO;
import com.foodie.backend.model.OrderStatus;

import java.util.List;

public interface OrderService {
    OrderDTO createOrder(OrderDTO orderDTO);
    OrderDTO getOrderById(String id);
    List<OrderDTO> getAllOrders();
    List<OrderDTO> getOrdersByUserId(String userId);
    List<OrderDTO> getOrdersByRestaurantId(String restaurantId);
    OrderDTO updateOrderStatus(String id, OrderStatus status);
    void deleteOrder(String id);
}