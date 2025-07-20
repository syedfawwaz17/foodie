package com.foodie.backend.dto;

import java.util.Date;
import java.util.List;

public class OrderDTO {
    private String id;
    private String userId;
    private String restaurantId;
    private List<String> itemIds;
    private Double totalPrice;
    private String status;
    private Date orderDate;
}
