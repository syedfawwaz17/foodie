package com.foodie.backend.controller;

import com.foodie.backend.dto.MenuItemDTO;
import com.foodie.backend.dto.RestaurantDTO;
import com.foodie.backend.service.RestaurantOwnerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owner")
@PreAuthorize("hasRole('RESTAURANT_OWNER')")
public class RestaurantOwnerController {

    @Autowired
    private RestaurantOwnerService restaurantOwnerService;

    @GetMapping("/restaurant")
    public ResponseEntity<RestaurantDTO> getMyRestaurant() {
        return ResponseEntity.ok(restaurantOwnerService.getMyRestaurant());
    }

    @PutMapping("/restaurant")
    public ResponseEntity<RestaurantDTO> updateRestaurant(@Valid @RequestBody RestaurantDTO dto) {
        return ResponseEntity.ok(restaurantOwnerService.updateRestaurant(dto));
    }

    @GetMapping("/menu")
    public ResponseEntity<List<MenuItemDTO>> getMenuItems() {
        return ResponseEntity.ok(restaurantOwnerService.getMenuItems());
    }

    @PostMapping("/menu")
    public ResponseEntity<MenuItemDTO> addMenuItem(@Valid @RequestBody MenuItemDTO dto) {
        MenuItemDTO created = restaurantOwnerService.addMenuItem(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/menu/{id}")
    public ResponseEntity<MenuItemDTO> updateMenuItem(
            @PathVariable String id,
            @Valid @RequestBody MenuItemDTO dto) {
        return ResponseEntity.ok(restaurantOwnerService.updateMenuItem(id, dto));
    }

    @DeleteMapping("/menu/{id}")
    public ResponseEntity<Void> deleteMenuItem(@PathVariable String id) {
        restaurantOwnerService.removeMenuItem(id);
        return ResponseEntity.noContent().build();
    }
}
