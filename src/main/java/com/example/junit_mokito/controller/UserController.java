package com.example.junit_mokito.controller;

import com.example.junit_mokito.model.User;
import com.example.junit_mokito.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private userService UserService;

    @GetMapping
    public List<User> getAllUsers() {
        return UserService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return UserService.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return UserService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        UserService.deleteUser(id);
    }
}
