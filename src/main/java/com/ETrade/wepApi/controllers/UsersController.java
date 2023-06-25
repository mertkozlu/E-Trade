package com.ETrade.wepApi.controllers;

import com.ETrade.business.UserService;
import com.ETrade.dto.requests.UpdateUserRequest;
import com.ETrade.dto.requests.CreateUserRequest;
import com.ETrade.dto.responses.GetAllUserResponse;
import com.ETrade.dto.responses.GetByIdUserResponse;
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
    public List<GetAllUserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/add")
    public User createOneUser(@RequestBody CreateUserRequest newUser) {
        return userService.saveOneUser(newUser);
    }

    @PutMapping("/{userId}")
    public User updateOneUser(@PathVariable Long userId,@RequestBody  UpdateUserRequest updateUserRequest) {
        return this.userService.updateOneUserById(userId, updateUserRequest);
    }

    @GetMapping("/{userId}")
    public GetByIdUserResponse getOneUser(@PathVariable Long userId) {
        return userService.getOneUser(userId);
    }

    @DeleteMapping("/{userId}")
    public void deleteById(@PathVariable Long userId) {
        this.userService.deleteByUser(userId);
    }



}
