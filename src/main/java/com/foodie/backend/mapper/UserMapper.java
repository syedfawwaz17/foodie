package com.foodie.backend.mapper;

import com.foodie.backend.dto.UserDTO;
import com.foodie.backend.model.User;

public class UserMapper {
    public UserDTO toDto(User user){
        if (user == null) return null;
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());

        return dto;
    }

    public User toEntity(UserDTO dto){
        if (dto == null ) return null;
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        return user;

    }
}
