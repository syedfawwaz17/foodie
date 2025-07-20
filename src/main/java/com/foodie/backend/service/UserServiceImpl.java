package com.foodie.backend.service;

import com.foodie.backend.dto.UserDTO;
import com.foodie.backend.dto.UserLoginDTO;
import com.foodie.backend.dto.UserRegistrationDTO;
import com.foodie.backend.mapper.UserMapper;
import com.foodie.backend.model.User;
import com.foodie.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDTO registerUser(UserRegistrationDTO userRegistrationDTO){
        if(userRepository.existsByEmail(userRegistrationDTO.getEmail())){
            throw new RuntimeException("Email already in use");
        }
        User user = userMapper.toEntity(userRegistrationDTO);
        user.setPassword(passwordEncoder.encode(userRegistrationDTO.getPassword()));
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }
    @Override
    public UserDTO loginUser(UserLoginDTO userLoginDTO){
        User user = userRepository.findByEmail(userLoginDTO.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid Credentials"));
        if(!passwordEncoder.matches(userLoginDTO.getPassword(), user.getPassword())){
            throw new RuntimeException("Invalid Credentials");

        }
        return userMapper.toDto(user);
    }
    @Override
    public UserDTO getUserById(String id) {
        User user = userRepository.findById(id).
                orElseThrow(()->new RuntimeException("User Not Found"));

        return userMapper.toDto(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> all = userRepository.findAll();
        return all.stream().
                map(userMapper::toDto)
                .toList();

    }

    @Override
    public UserDTO updateUser(String id, UserDTO userDto) {

        User found = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        found.setName(userDto.getName());
        found.setEmail(userDto.getEmail());
        User save = userRepository.save(found);
        return userMapper.toDto(save);
    }

    @Override
    public void deleteUser(String id) {

         userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.deleteById(id);



    }

    @Override
    public UserDTO findByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(()->new RuntimeException("User Not Found"));
        return userMapper.toDto(user);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
