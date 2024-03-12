package com.example.demo.v2.user.api;

import com.example.demo.User;
import com.example.demo.v2.user.api.request.UserSaveRequest;
import com.example.demo.v2.user.api.response.UserSaveResponse;
import com.example.demo.v2.user.dto.UserSaveDto;
import com.example.demo.v2.user.service.UserServiceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserControllerV2 {

    private final UserServiceV2 userService;

    @PostMapping("v2/users")
    @ResponseStatus(HttpStatus.CREATED)
    private UserSaveResponse saveUser(@RequestBody UserSaveRequest request) {
        UserSaveDto userSaveDto = new UserSaveDto(request.getName(), request.getAge());
        User user = userService.save(userSaveDto);

        return UserSaveResponse.from(user);
    }
}
