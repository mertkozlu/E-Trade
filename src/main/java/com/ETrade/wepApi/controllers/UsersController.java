package com.ETrade.wepApi.controllers;

import com.ETrade.business.concretes.UserService;
import com.ETrade.dto.responses.GetAllUsersResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UsersController {
    private final UserService userService;

    @GetMapping
    public List<GetAllUsersResponse> getAll() {
        return this.userService.getAll();
    }
}
