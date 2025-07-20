package com.foodie.backend.mapper;

import com.foodie.backend.dto.UserDTO;
import com.foodie.backend.dto.UserLoginDTO;
import com.foodie.backend.dto.UserRegistrationDTO;
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
    public User toEntity(UserRegistrationDTO regDto) {
        if (regDto == null) return null;
        User user = new User();
        user.setName(regDto.getName());
        user.setEmail(regDto.getEmail());
        user.setPassword(regDto.getPassword());
        return user;
    }


    public UserRegistrationDTO toRegistrationDto(User user) {
        if (user == null) return null;
        UserRegistrationDTO regDto = new UserRegistrationDTO();
        regDto.setName(user.getName());
        regDto.setEmail(user.getEmail());

        return regDto;
    }


    public User toEntity(UserLoginDTO loginDto) {
        if (loginDto == null) return null;
        User user = new User();
        user.setEmail(loginDto.getEmail());
        user.setPassword(loginDto.getPassword());
        return user;
    }


    public UserLoginDTO toLoginDto(User user) {
        if (user == null) return null;
        UserLoginDTO loginDto = new UserLoginDTO();
        loginDto.setEmail(user.getEmail());

        return loginDto;
    }
}
