package com.ETrade.dto.requests;

import lombok.Data;

import java.util.Date;

@Data
public class CreateUserRequests {
    private String userName;
    private String password;
    private String email;
    private Date birthDate;
    private int age;
}
