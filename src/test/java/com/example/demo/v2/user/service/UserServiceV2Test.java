package com.example.demo.v2.user.service;

import com.example.demo.User;
import com.example.demo.UserRepository;
import com.example.demo.v2.user.dto.UserSaveDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceV2Test {

    @InjectMocks
    private UserServiceV2 userService;

    @Mock
    private UserRepository userRepository;

    @Test
    void saveUser() {
        UserSaveDto userSaveDto = new UserSaveDto("tester", 25);
        when(userRepository.save(any(User.class)))
                .then(invocation -> invocation.getArgument(0));
        User result = userService.save(userSaveDto);

        assertThat(result.getAge()).isEqualTo(25);
        assertThat(result.getName()).isEqualTo("tester");

        ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);
        verify(userRepository, times(1)).save(userArgumentCaptor.capture());
        User user = userArgumentCaptor.getValue();
        assertThat(user.getName()).isEqualTo("tester");
        assertThat(user.getAge()).isEqualTo(25);
    }

}