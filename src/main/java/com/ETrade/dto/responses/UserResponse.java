package com.ETrade.dto.responses;

import lombok.Data;

@Data
public class UserResponse {
    private Long userId;
    private String userName;
    private String email;

//    public UserResponse (User entity) {
//        this.userId = entity.getUserId();
//        this.userName = entity.getUserName();
//        this.email = entity.getEmail();
//    }
}
