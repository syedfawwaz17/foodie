package com.foodie.backend.service;

import com.foodie.backend.dto.*;

import java.util.List;

public interface UserService {
    AuthResponseDTO registerUser(UserRegistrationDTO registrationDto);
    AuthResponseDTO loginUser(UserLoginDTO loginDto);
    UserDTO getUserById(String id);
    List<UserDTO> getAllUsers();
    UserDTO updateUser(String id, UserDTO userDto);
    void deleteUser(String id);
    UserDTO findByEmail(String email);
    boolean existsByEmail(String email);
}