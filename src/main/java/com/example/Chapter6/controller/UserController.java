package com.example.Chapter6.controller;

import com.example.Chapter6.model.User;
import com.example.Chapter6.service.UserService;
import com.example.Chapter6.service.implementasi.UserServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User register(@RequestBody User user) {
            if (user.getUsername().isEmpty()) {
                throw new IllegalArgumentException("Username tidak boleh kosong");
            }

            if (user.getEmail().isEmpty()) {
                throw new IllegalArgumentException("Email tidak boleh kosong");
            }

            if (user.getPassword().isEmpty()) {
                throw new IllegalArgumentException("Password tidak boleh kosong");
            }

            return userService.addUser(user);

    }

}