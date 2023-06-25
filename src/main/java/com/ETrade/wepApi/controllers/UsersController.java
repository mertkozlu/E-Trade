package com.ETrade.wepApi.controllers;

import com.ETrade.business.UserService;
import com.ETrade.dto.requests.UpdateUserRequest;
import com.ETrade.dto.requests.UserRequest;
import com.ETrade.dto.responses.UserResponse;
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
    public User createOneUser(@RequestBody User newUser) {
        return userService.saveOneUser(newUser);
    }

    @PutMapping("/{userId}")
    public User updateOneUser(@PathVariable Long userId,@RequestBody  UpdateUserRequest updateUserRequest) {
        return this.userService.updateOneUserById(userId, updateUserRequest);
    }

    @GetMapping("/{userId}")
    public UserResponse getOneUser(@PathVariable Long userId) {
        return userService.getOneUser(userId);
    }

    @DeleteMapping("/{userId}")
    public void deleteById(@PathVariable Long userId) {
        this.userService.deleteByUser(userId);
    }



}
