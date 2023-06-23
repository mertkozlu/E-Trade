package com.ETrade.dto.requests;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class RefreshRequest {
    @NotNull
    private Long userId;
    @NotNull
    @NotBlank
    private String refreshToken;
}
