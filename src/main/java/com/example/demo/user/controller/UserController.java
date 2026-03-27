package com.example.demo.user.controller;

import com.example.demo.common.ApiResponse;
import com.example.demo.user.dto.request.CreateUserRequest;
import com.example.demo.user.dto.request.GetUserRequest;
import com.example.demo.user.dto.response.UserResponse;
import com.example.demo.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;

@RestController
@RequestMapping("Api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<ApiResponse<UserResponse>> createUser(@Valid @RequestBody CreateUserRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(userService.createUser(request), "Tạo user thành công"));
    }

    @GetMapping("search/{username}")
    public ResponseEntity<ApiResponse<UserResponse>> getUserByUserName(@Valid @PathVariable String username) {
        return ResponseEntity.ok(ApiResponse.success(userService.getUserByUsername(username)));
    }
}
