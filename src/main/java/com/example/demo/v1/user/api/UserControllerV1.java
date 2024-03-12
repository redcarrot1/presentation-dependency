package com.example.demo.v1.user.api;

import com.example.demo.v1.user.dto.request.UserSaveRequest;
import com.example.demo.v1.user.dto.response.UserSaveResponse;
import com.example.demo.v1.user.service.UserServiceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserControllerV1 {

    private final UserServiceV1 userService;

    @PostMapping("v1/users")
    @ResponseStatus(HttpStatus.CREATED)
    private UserSaveResponse saveUser(@RequestBody UserSaveRequest request) {
        return userService.save(request);
    }
}
