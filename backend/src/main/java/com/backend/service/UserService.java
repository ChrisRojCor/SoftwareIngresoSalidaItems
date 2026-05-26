package com.backend.service;

import com.backend.mapper.UserMapper;
import com.backend.model.dto.UserRequestDto;
import com.backend.model.dto.UserResponseDto;
import com.backend.model.entity.User;
import com.backend.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponseDto saveUser(UserRequestDto dto) {
        User user = userMapper.toEntity(dto);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        return userMapper.toResponseDTO(userRepository.save(user));
    }

    public List<UserResponseDto> getAllUsers() {
        return userMapper.toResponseDTOList(
                userRepository.findAll());
    }

    public UserResponseDto getUserById(int id) {
        return userMapper.toResponseDTO(
                userRepository.findById(id).orElse(null));
    }

    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }
}
