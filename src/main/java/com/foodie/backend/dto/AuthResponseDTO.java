package com.foodie.backend.dto;

import java.time.Instant;

public class AuthResponseDTO {
    private String accessToken;
    private String tokenType = "Bearer";
    private Instant expiresAt;
    private UserDTO user;

    // Constructors, getters and setters
    public AuthResponseDTO(String token, UserDTO userDTO) {}

    public AuthResponseDTO(String accessToken, String tokenType, Instant expiresAt, UserDTO user) {
        this.accessToken = accessToken;
        this.tokenType = tokenType;
        this.expiresAt = expiresAt;
        this.user = user;
    }

    // Getters and Setters
    public String getAccessToken() { return accessToken; }
    public void setAccessToken(String accessToken) { this.accessToken = accessToken; }
    public String getTokenType() { return tokenType; }
    public void setTokenType(String tokenType) { this.tokenType = tokenType; }
    public Instant getExpiresAt() { return expiresAt; }
    public void setExpiresAt(Instant expiresAt) { this.expiresAt = expiresAt; }
    public UserDTO getUser() { return user; }
    public void setUser(UserDTO user) { this.user = user; }
}