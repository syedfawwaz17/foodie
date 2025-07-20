package com.foodie.backend.dto;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
public class MenuItemDTO {
    private String id;
    private String name;
    private String description;
    private String price;
    private String restaurantId;
}
