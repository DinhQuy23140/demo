package com.example.demo.user.service;

import com.example.demo.common.DuplicateEmailException;
import com.example.demo.user.dto.request.CreateUserRequest;
import com.example.demo.user.dto.request.GetUserRequest;
import com.example.demo.user.dto.response.UserResponse;
import com.example.demo.user.entity.User;
import com.example.demo.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public UserResponse createUser(CreateUserRequest createUserRequest) {
        if (userRepository.existsUserByEmail(createUserRequest.getEmail())) {
            throw new DuplicateEmailException(createUserRequest.getEmail());
        }
        User user = User.builder()
                .fullname(createUserRequest.getUsername())
                .email(createUserRequest.getEmail())
                .password(createUserRequest.getPassword())
                .build();
        return toResponse(userRepository.save(user));
    }

    public UserResponse getUserByUsername(String username) {
        return toResponse(userRepository.getUserByUserName(username));
    }

    private UserResponse toResponse(User user) {
        return UserResponse.builder()
                .userName(user.getFullname())
                .password(user.getPassword())
                .email(user.getEmail())
                .build();
    }
}
