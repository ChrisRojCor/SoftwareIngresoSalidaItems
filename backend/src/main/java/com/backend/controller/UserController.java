package com.backend.controller;

import com.backend.model.dto.UserRequestDto;
import com.backend.model.dto.UserResponseDto;
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
    public UserResponseDto create(@Valid @RequestBody UserRequestDto userRequestDto) {
        return userService.saveUser(userRequestDto);
    }

    @GetMapping
    public List<UserResponseDto> read() {
        return userService.getAllUsers();
    }

    @GetMapping("{id}")
    public UserResponseDto readById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        userService.deleteUserById(id);
    }

    @PutMapping("/{id}")
    public UserResponseDto update(@PathVariable int id, @Valid @RequestBody UserRequestDto userRequestDto) {
        return userService.updateUser(id, userRequestDto);
    }
}
