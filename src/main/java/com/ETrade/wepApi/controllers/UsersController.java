package com.ETrade.wepApi.controllers;

import com.ETrade.business.UserService;
import com.ETrade.dto.requests.CreateUserRequest;
import com.ETrade.dto.requests.UpdateUserRequest;
import com.ETrade.entities.User;
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
    public User createOneUser(@RequestBody CreateUserRequest newUser) {
        return userService.saveOneUser(newUser);
    }

    @PutMapping("/{userId}")
    public User updateOneUser(@PathVariable Long userId,@RequestBody  UpdateUserRequest updateUserRequest) {
        return this.userService.updateOnePostById(userId, updateUserRequest);
    }



}
