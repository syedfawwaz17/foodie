package com.foodie.backend.service;

import com.foodie.backend.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO registerUser(UserDTO userDto, String rawPassword);

    UserDTO getUserById(String id);
    List<UserDTO> getAllUsers();
    UserDTO updateUser(String id, UserDTO userDto);
    void deleteUser(String id);
    UserDTO findByEmail(String email);
    boolean existsByEmail(String email);
}
