package com.foodie.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;

import java.util.Map;

public class RestaurantRegistrationDTO {

    @NotBlank(message = "Restaurant name is required")
    private String name;

    @NotBlank(message = "Address is required")
    private String address;

    @NotBlank(message = "Cuisine type is required")
    private String cuisineType;

    @NotBlank(message = "Owner email is required")
    @Email(message = "Invalid email format")
    private String ownerEmail;

    @NotBlank(message = "Owner password is required")
    private String ownerPassword;

    // Optional extra fields for advanced info
    private String businessLicense;
    private String taxId;
    private Map<String, String> operatingHours; // e.g., {"monday": "09:00-22:00"}

    // --- Getters and Setters ---

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public String getOwnerPassword() {
        return ownerPassword;
    }

    public void setOwnerPassword(String ownerPassword) {
        this.ownerPassword = ownerPassword;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public Map<String, String> getOperatingHours() {
        return operatingHours;
    }

    public void setOperatingHours(Map<String, String> operatingHours) {
        this.operatingHours = operatingHours;
    }
}
