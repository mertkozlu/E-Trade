package com.ETrade.businessRules;

import com.ETrade.core.utilities.exceptions.BusinessException;
import com.ETrade.core.utilities.exceptions.UserNotFoundException;
import com.ETrade.dataAccess.CategoryRepository;
import com.ETrade.dataAccess.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserBusinessRules {
    private final UserRepository userRepository;

    public void existsByUserName(String userName) {
        if (this.userRepository.existsByUserName(userName)) {
            throw new UserNotFoundException("User already available !");
        }
    }

    public void existsByEmail(String email) {
        if (this.userRepository.existsByEmail(email)) {
            throw new BusinessException("Email already available !");
        }
    }

    public void createPassword(String password) {
        if (password.length() < 8) {
            throw new BusinessException("Password cannot be less than 8 characters !");
        }
    }

}
