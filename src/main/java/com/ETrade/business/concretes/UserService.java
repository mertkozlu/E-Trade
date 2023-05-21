package com.ETrade.business.concretes;

import com.ETrade.dataAccess.abstracts.UserRepository;
import com.ETrade.dto.requests.CreateUserRequest;
import com.ETrade.dto.requests.UpdateUserRequest;
import com.ETrade.dto.responses.GetAllUsersResponse;
import com.ETrade.entities.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;


    public List<GetAllUsersResponse> getAll() {

        List<User> users = userRepository.findAll();
        List<GetAllUsersResponse> usersResponse = new ArrayList<GetAllUsersResponse>();

        for (User user : users) {
            GetAllUsersResponse responseItem = new GetAllUsersResponse();
            responseItem.setUserId(user.getUserId());
            responseItem.setUserName(user.getUserName());
        }
        return usersResponse;
    }

    public GetAllUsersResponse getById(int userId) {
        return null;
    }

    public void add(CreateUserRequest createUserRequest) {

    }

    public void update(UpdateUserRequest updateUserRequest) {

    }

    public void deleteById(int userId) {

    }


}
