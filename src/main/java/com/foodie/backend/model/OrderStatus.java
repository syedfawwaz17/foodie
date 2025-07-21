package com.foodie.backend.model;

public enum OrderStatus {
    PENDING("Order received and pending confirmation"),
    CONFIRMED("Order confirmed by restaurant"),
    PREPARING("Food is being prepared"),
    OUT_FOR_DELIVERY("Order is out for delivery"),
    DELIVERED("Order has been delivered"),
    CANCELLED("Order was cancelled");

    private final String description;

    OrderStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
