package com.ETrade.dto.responses;

import lombok.Data;

@Data
public class GetByIdUserResponse {
    private Long userId;
    private String userName;
    private String email;
}
