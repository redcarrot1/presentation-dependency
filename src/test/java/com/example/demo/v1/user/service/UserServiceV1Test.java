package com.example.demo.v1.user.service;

import com.example.demo.User;
import com.example.demo.v1.user.dto.request.UserSaveRequest;
import com.example.demo.v1.user.dto.response.UserSaveResponse;
import com.example.demo.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserServiceV1Test {

    @InjectMocks
    private UserServiceV1 userService;

    @Mock
    private UserRepository userRepository;

    @Test
    void saveUser() {
        UserSaveRequest userSaveRequest = new UserSaveRequest("tester", 25);
        UserSaveResponse result = userService.save(userSaveRequest);

        assertThat(result.getName()).isEqualTo("tester");

        ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);
        verify(userRepository, times(1)).save(userArgumentCaptor.capture());
        User user = userArgumentCaptor.getValue();
        assertThat(user.getName()).isEqualTo("tester");
        assertThat(user.getAge()).isEqualTo(25);
    }

}