package com.foodie.backend.dto;

import jakarta.validation.constraints.NotBlank;

public class RestaurantRegistrationDTO {
    @NotBlank
    private String name;

    @NotBlank
    private String address;

    @NotBlank
    private String cuisineType;

    @NotBlank
    private String ownerEmail;

    @NotBlank
    private String ownerPassword;

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getCuisineType() { return cuisineType; }
    public void setCuisineType(String cuisineType) { this.cuisineType = cuisineType; }
    public String getOwnerEmail() { return ownerEmail; }
    public void setOwnerEmail(String ownerEmail) { this.ownerEmail = ownerEmail; }
    public String getOwnerPassword() { return ownerPassword; }
    public void setOwnerPassword(String ownerPassword) { this.ownerPassword = ownerPassword; }
}