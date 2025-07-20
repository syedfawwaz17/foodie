package com.foodie.backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "menus")
public class Menu {
    @Id
    private String id;
    private String name;
    private String description;
    private String price;
    @DBRef
    private String restaurantId;

}
