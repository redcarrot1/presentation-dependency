package com.example.demo.v1.user.service;

import com.example.demo.User;
import com.example.demo.UserRepository;
import com.example.demo.v1.user.dto.request.UserSaveRequest;
import com.example.demo.v1.user.dto.response.UserSaveResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceV1 {

    private final UserRepository userRepository;

    @Transactional
    public UserSaveResponse save(UserSaveRequest request) {
        User user = new User(request.getName(), request.getAge());
        userRepository.save(user);

        return new UserSaveResponse(user.getName());
    }
}
