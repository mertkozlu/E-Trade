package com.ETrade.wepApi.controllers;

import com.ETrade.business.concretes.UserService;
import com.ETrade.dto.requests.CreateUserRequests;
import com.ETrade.entities.concretes.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    private final UserService userService;

    public UsersController (UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/add")
    public User createOneUser(@RequestBody CreateUserRequests newUser) {
        return userService.saveOneUser(newUser);
    }



}
