package com.ETrade.business.concretes;

import com.ETrade.businessRules.UserBusinessRules;
import com.ETrade.core.utilities.mappers.ModelMapperService;
import com.ETrade.dataAccess.abstracts.UserRepository;
import com.ETrade.dto.requests.CreateUserRequests;
import com.ETrade.entities.concretes.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserBusinessRules userBusinessRules;
    private final ModelMapperService modelMapperService;

    public UserService(UserRepository userRepository, UserBusinessRules userBusinessRules,
                       ModelMapperService modelMapperService) {
        this.userRepository = userRepository;
        this.userBusinessRules = userBusinessRules;
        this.modelMapperService = modelMapperService;
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveOneUser(CreateUserRequests newUser) {
        this.userBusinessRules.existsByUserName(newUser.getUserName());
        this.userBusinessRules.existsByEmail(newUser.getEmail());
        this.userBusinessRules.createPassword(newUser.getPassword());
        User user = modelMapperService.forRequest().map(newUser, User.class);
      return userRepository.save(user);
    }
}
