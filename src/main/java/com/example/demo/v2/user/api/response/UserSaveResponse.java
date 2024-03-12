package com.example.demo.v2.user.api.response;

import com.example.demo.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserSaveResponse {

    private String name;

    public static UserSaveResponse from(User user) {
        return new UserSaveResponse(user.getName());
    }
}
