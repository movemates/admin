package com.movemates.admin.controller;

import com.movemates.admin.model.User;
import com.movemates.admin.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AdminController {

    private final UserService userService;
    @PostMapping("/login")
    public String authenticate(@RequestBody User user) {
        return userService.authenticate(user);
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }
}
