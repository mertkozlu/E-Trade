package com.ETrade.business;

import com.ETrade.businessRules.UserBusinessRules;
import com.ETrade.core.utilities.exceptions.BusinessException;
import com.ETrade.core.utilities.exceptions.UserNotFoundException;
import com.ETrade.core.utilities.mappers.ModelMapperService;
import com.ETrade.dataAccess.UserRepository;
import com.ETrade.dto.requests.UpdateUserRequest;
import com.ETrade.dto.requests.CreateUserRequest;
import com.ETrade.dto.responses.GetAllUserResponse;
import com.ETrade.dto.responses.GetByIdUserResponse;
import com.ETrade.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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


    public List<GetAllUserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<GetAllUserResponse> userResponses = users.stream().map(user -> this.modelMapperService.forResponse()
                .map(user, GetAllUserResponse.class)).collect(Collectors.toList());
        return userResponses;
    }

    public User saveOneUser(CreateUserRequest newUser) {
        this.userBusinessRules.existsByUserName(newUser.getUserName());
        this.userBusinessRules.existsByEmail(newUser.getEmail());
        this.userBusinessRules.createPassword(newUser.getPassword());
        User user = modelMapperService.forRequest().map(newUser, User.class);
        return userRepository.save(user);
    }

    public User updateOneUserById(Long userId, UpdateUserRequest updateUserRequest) {
        User user = userRepository.findById(userId).orElse(null);
        if (Objects.nonNull(user)) {
            user.setUserName(updateUserRequest.getUserName());
            user.setEmail(updateUserRequest.getEmail());
            user.setPassword(updateUserRequest.getPassword());
            user.setBirthDate(updateUserRequest.getBirthDate());
            user.setAge(updateUserRequest.getAge());
            userRepository.save(user);
            return user;
        }
        throw new UserNotFoundException("User could not found");
    }


    public GetByIdUserResponse getOneUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new BusinessException("User can not found."));
        GetByIdUserResponse userResponse = this.modelMapperService.forResponse().map(user, GetByIdUserResponse.class);
        return userResponse;
    }

    public void deleteByUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new BusinessException("User can not found."));
        this.userRepository.deleteById(userId);
    }

    public User getOneUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}
