package com.foodie.backend.mapper;

import com.foodie.backend.dto.OrderDTO;
import com.foodie.backend.model.Order;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.stream.Collectors;

public class OrderMapper {

    public OrderDTO toDto(Order order) {
        if (order == null) return null;

        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setOrderDate(convertToDate(order.getOrderDate()));
        dto.setStatus(order.getStatus());
        dto.setUserId(order.getUserId());
        dto.setRestaurantId(order.getRestaurantId());
        dto.setItemIds(order.getItems());
        dto.setTotalPrice(order.getTotalPrice());
        return dto;
    }

    public Order toEntity(OrderDTO orderDTO) {
        if (orderDTO == null) return null;

        Order order = new Order();
        order.setId(orderDTO.getId());
        order.setOrderDate(convertToLocalDateTime(orderDTO.getOrderDate()));
        order.setStatus(orderDTO.getStatus());
        order.setUserId(orderDTO.getUserId());
        order.setRestaurantId(orderDTO.getRestaurantId());
        order.setItems(orderDTO.getItemIds());
        order.setTotalPrice(orderDTO.getTotalPrice());
        return order;
    }


    private Date convertToDate(LocalDateTime localDateTime) {
        if (localDateTime == null) return null;
        return Date.from(localDateTime.atZone(java.time.ZoneId.systemDefault()).toInstant());
    }

    private LocalDateTime convertToLocalDateTime(Date date) {
        if (date == null) return null;
        return date.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDateTime();
    }
}