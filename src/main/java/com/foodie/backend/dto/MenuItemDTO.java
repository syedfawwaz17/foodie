package com.foodie.backend.dto;


import javax.validation.constraints.*;
import java.math.BigDecimal;

public class MenuItemDTO {
    private String id;

    @NotBlank(message = "Menu item name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @Size(max = 500, message = "Description cannot exceed 500 characters")
    private String description;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.01", message = "Price must be greater than 0")
    @Digits(integer = 6, fraction = 2, message = "Price format is invalid")
    private BigDecimal price;  // FIXED: Changed from String to BigDecimal

    @NotBlank(message = "Restaurant ID is required")
    private String restaurantId;

    // getters and setters...
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public String getRestaurantId() { return restaurantId; }
    public void setRestaurantId(String restaurantId) { this.restaurantId = restaurantId; }
}