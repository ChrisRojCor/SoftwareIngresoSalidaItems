package com.backend.service;

import com.backend.model.entity.User;
import com.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;

    }

    public void saveUser(User user) {

        userRepository.save(user);

    }

    public List<User> getAllUsers() {

        return userRepository.findAll();

    }

    public User getUserById(int id) {

        return userRepository.findById(id).orElse(null);

    }

    public void deleteUserById(int id){

        userRepository.deleteById(id);

    }

}
