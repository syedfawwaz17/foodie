package com.foodie.backend.security;

import com.foodie.backend.model.User;
import com.foodie.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("userSecurity")
public class UserSecurity {

    @Autowired
    UserRepository userRepository;

    public boolean isOwner(String id, String username) {
        return userRepository.findById(id)
                .map(User::getEmail)
                .map(email -> email.equals(username))
                .orElse(false);
    }

    public boolean isOwnerByEmail(String email, String username) {
        return email.equals(username);
    }
}
