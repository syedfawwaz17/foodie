package com.foodie.backend.service;

import com.foodie.backend.dto.UserDTO;
import com.foodie.backend.dto.UserLoginDTO;
import com.foodie.backend.dto.UserRegistrationDTO;

import java.util.List;

public interface UserService {
    UserDTO registerUser(UserRegistrationDTO registrationDto);
    UserDTO loginUser(UserLoginDTO loginDto);

    UserDTO getUserById(String id);
    List<UserDTO> getAllUsers();
    UserDTO updateUser(String id, UserDTO userDto);
    void deleteUser(String id);
    UserDTO findByEmail(String email);
    boolean existsByEmail(String email);
}
