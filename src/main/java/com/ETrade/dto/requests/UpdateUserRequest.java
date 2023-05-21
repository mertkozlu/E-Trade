package com.ETrade.dto.requests;

import lombok.Data;

@Data
public class UpdateUserRequest {
    private int userId;
    private String userName;
}
