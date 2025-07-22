    package com.foodie.backend.dto;

    public class RestaurantDTO {
        private String id;
        private String name;
        private String address;
        private String cuisineType;
        private Boolean approved;    // ✅ Nullable safer for backward MongoDB data
        private Boolean suspended;

        // Getters and Setters ...
        public String getId() { return id; }
        public void setId(String id) { this.id = id; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getAddress() { return address; }
        public void setAddress(String address) { this.address = address; }

        public String getCuisineType() { return cuisineType; }
        public void setCuisineType(String cuisineType) { this.cuisineType = cuisineType; }

        public Boolean getApproved() { return approved; }
        public void setApproved(Boolean approved) { this.approved = approved; }

        public Boolean getSuspended() { return suspended; }
        public void setSuspended(Boolean suspended) { this.suspended = suspended; }
    }
