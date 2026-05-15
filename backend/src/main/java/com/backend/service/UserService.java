package com.backend.service;

import com.backend.mapper.UserMapper;
import com.backend.model.dto.UserDTO;
import com.backend.model.dto.UserResponseDTO;
import com.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserResponseDTO saveUser(UserDTO userDTO) {
        return userMapper.toResponseDTO(
                userRepository.save(
                        userMapper.toEntity(userDTO)));
    }

    public List<UserResponseDTO> getAllUsers() {
        return userMapper.toResponseDTOList(
                userRepository.findAll());
    }

    public UserResponseDTO getUserById(int id) {
        return userMapper.toResponseDTO(
                userRepository.findById(id).orElse(null));
    }

    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }
}
