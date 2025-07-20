package com.foodie.backend.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Data
@Getter
@Setter
public class OrderDTO {
    private String id;
    private String userId;
    private String restaurantId;
    private List<String> itemIds;
    private int totalPrice;
    private String status;
    private Date orderDate;


}
