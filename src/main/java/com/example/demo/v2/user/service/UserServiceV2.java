package com.example.demo.v2.user.service;

import com.example.demo.User;
import com.example.demo.UserRepository;
import com.example.demo.v2.user.dto.UserSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceV2 {

    private final UserRepository userRepository;

    @Transactional
    public User save(UserSaveDto userSaveDto) {
        User user = new User(userSaveDto.name(), userSaveDto.age());
        return userRepository.save(user);
    }
}
