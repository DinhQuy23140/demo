package com.example.demo.auth.service;

import com.example.demo.auth.dto.request.LoginRequest;
import com.example.demo.auth.dto.response.LoginResponse;
import com.example.demo.auth.dto.request.RegisterRequest;
import com.example.demo.auth.dto.response.RegisterResponse;
import com.example.demo.auth.sercurity.jwt.JwtService;

import com.example.demo.user.entity.User;
import com.example.demo.user.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(AuthenticationManager authenticationManager, JwtService jwtService, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public LoginResponse login(LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
                    String accessToken = jwtService.generateToken(authentication);
            String refreshToken = jwtService.generateRefreshToken(userDetails);
            return LoginResponse.builder()
                    .accessToken(accessToken)
                    .refreshToken(refreshToken)
                    .tokenType("Bearer")
                    .expiresIn(3600)
                    .user(userDetails)
                    .build();
        } catch (BadCredentialsException e) {
            throw new RuntimeException("Invalid email or password");
        }
    }

    public Object register(RegisterRequest request) {
        try {
            if (request.getEmail() == null || request.getPassword() == null) {
                throw new RuntimeException("Email and password are required");
            }

            if (userRepository.existsUserByEmail(request.getEmail())) {
                throw new RuntimeException("Email is already in use");
            }

            String passwordEncoded = passwordEncoder.encode(request.getPassword());
            User user = User.builder()
                    .fullname(request.getFullname())
                    .email(request.getEmail())
                    .password(passwordEncoded)
                    .role(request.getRole() != null ? request.getRole() : "student")
                    .build();
            User response = userRepository.save(user);
            return ResponseEntity.ok(RegisterResponse.builder()
                    .id(response.getId())
                    .email(response.getEmail())
                    .name(response.getFullname())
                    .role(response.getRole())
                    .createdAt(response.getCreatedAt())
                    .build());
        } catch (RuntimeException e) {
            throw new RuntimeException("Registration failed: " + e.getMessage());
        }
    }
}
