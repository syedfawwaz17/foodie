package com.foodie.backend.controller;

import com.foodie.backend.dto.RestaurantRegistrationDTO;
import com.foodie.backend.service.RestaurantRegistrationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/register/restaurant")
public class RestaurantRegistrationController {

    @Autowired
    private RestaurantRegistrationService registrationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void registerRestaurant(@Valid @RequestBody RestaurantRegistrationDTO registrationDTO) {
        registrationService.registerRestaurant(registrationDTO);
    }
}