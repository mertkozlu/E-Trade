package com.ETrade.business.abstracts;

import com.ETrade.dto.responses.GetAllUsersResponse;

import java.util.List;

public interface UserService {
    List<GetAllUsersResponse> getAll();
}
