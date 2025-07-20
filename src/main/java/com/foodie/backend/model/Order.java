package com.foodie.backend.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Getter
@Setter
@Document(collection = "users")
public class Order {
    @Id
    private String id;
    @DBRef
    private String userId;
    @DBRef
    private String restaurantId;
    private List<String> items;
    private Double totalPrice;
    private String status;
    private Data orderDate;


}
