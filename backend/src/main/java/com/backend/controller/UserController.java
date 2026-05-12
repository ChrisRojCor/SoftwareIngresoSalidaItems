package com.backend.controller;

import com.backend.repository.UserRepository;
import com.backend.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/create")
    public void create(@RequestBody User user) { userRepository.save(user); }

    @GetMapping("/read")
    public List<User> read() { return userRepository.findAll(); }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Integer id) { userRepository.deleteById(id); }

    @PutMapping("/update")
    public void update(@RequestBody User user) { userRepository.save(user); }
}
