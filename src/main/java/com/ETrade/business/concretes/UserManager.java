package com.ETrade.business.concretes;

import com.ETrade.business.abstracts.UserService;
import com.ETrade.dataAccess.abstracts.UserRepository;
import com.ETrade.dto.responses.GetAllUsersResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserManager implements UserService {
    private UserRepository userRepository;

    @Override
    public List<GetAllUsersResponse> getAll() {
        return null;
    }
}
