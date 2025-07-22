
package com.foodie.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "restaurants")
public class Restaurant {

    @Id
    private String id;
    private String name;
    private String address;
    private String cuisineType;
    private String ownerId;

    private Boolean approved = false;
    private Boolean suspended = false;

    // Getters and Setters
    public String getOwnerId() {
        return ownerId;
    }
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    // FIX: Safely handle null values to prevent NullPointerException
    public Boolean isApproved() {
        return approved != null && approved;
    }

    public Boolean getApproved() {
        return approved;
    }


    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    // FIX: Safely handle null values to prevent NullPointerException
    public Boolean isSuspended() {
        return suspended != null && suspended;
    }

    public Boolean getSuspended() {
        return suspended;
    }

    public void setSuspended(Boolean suspended) {
        this.suspended = suspended;
    }
}
