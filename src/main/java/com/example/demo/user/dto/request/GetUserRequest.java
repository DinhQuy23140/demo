package com.example.demo.user.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetUserRequest {
    private String username;

    private String email;
}
