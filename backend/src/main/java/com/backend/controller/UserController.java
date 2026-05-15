package com.backend.controller;

import com.backend.model.dto.UserDTO;
import com.backend.model.dto.UserResponseDTO;
import com.backend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserResponseDTO create(@Valid @RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }

    @GetMapping
    public List<UserResponseDTO> read() {
        return userService.getAllUsers();
    }

    @GetMapping("{id}")
    public UserResponseDTO readById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        userService.deleteUserById(id);
    }

    @PutMapping
    public UserResponseDTO update(@Valid @RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }
}
