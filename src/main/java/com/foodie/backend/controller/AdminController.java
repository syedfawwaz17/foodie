package com.foodie.backend.controller;

import com.foodie.backend.dto.RestaurantDTO;
import com.foodie.backend.dto.UserDTO;
import com.foodie.backend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/users")
    public List<UserDTO> getAllUsers() {
        return adminService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public UserDTO getUserById(@PathVariable String id) {
        return adminService.getUserById(id);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable String id) {
        adminService.deleteUser(id);
    }

    @GetMapping("/restaurants")
    public List<RestaurantDTO> getAllRestaurants() {
        return adminService.getAllRestaurants();
    }

    @PostMapping("/restaurants/{id}/approve")
    public RestaurantDTO approveRestaurant(@PathVariable String id) {
        return adminService.approveRestaurant(id);
    }

    @PostMapping("/restaurants/{id}/suspend")
    public void suspendRestaurant(@PathVariable String id) {
        adminService.suspendRestaurant(id);
    }
}