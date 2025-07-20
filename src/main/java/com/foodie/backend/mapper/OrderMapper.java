package com.foodie.backend.mapper;

import com.foodie.backend.dto.OrderDTO;
import com.foodie.backend.model.Order;
import lombok.Data;

import java.util.Date;

public class OrderMapper {
    public OrderDTO toDto(Order order){
        if (order == null) return null;
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setOrderDate((Date) order.getOrderDate());
        dto.setStatus(order.getStatus());
        dto.setUserId(order.getUserId());
        dto.setRestaurantId(order.getRestaurantId());
        dto.setItemIds(order.getItems());
        dto.setTotalPrice(order.getTotalPrice());
         return dto;


    }

    public Order toEntity(OrderDTO orderDTO){
        if (orderDTO == null) return null;
        Order order = new Order();
        order.setId(orderDTO.getId());
        order.setOrderDate((Data) orderDTO.getOrderDate());
        order.setStatus(orderDTO.getStatus());
        order.setUserId(orderDTO.getUserId());
        order.setRestaurantId(orderDTO.getRestaurantId());
        order.setItems(orderDTO.getItemIds());
        order.setTotalPrice(orderDTO.getTotalPrice());
        return order;
    }
}
