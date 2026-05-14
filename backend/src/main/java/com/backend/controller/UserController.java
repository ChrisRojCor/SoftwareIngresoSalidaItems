package com.backend.controller;

import com.backend.model.entity.User;
import com.backend.service.UserService;
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
    public void create(@RequestBody User user) {
        userService.saveUser(user);
    }

    @GetMapping
    public List<User> read() {
        return userService.getAllUsers();
    }

    @GetMapping("{id}")
    public User readById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        userService.deleteUserById(id);
    }

    @PutMapping
    public void update(@RequestBody User user) {
        userService.saveUser(user);
    }
}
