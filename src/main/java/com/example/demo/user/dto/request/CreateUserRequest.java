package com.example.demo.user.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequest {
    @NotBlank(message = "Username không được bỏ trống")
    @Size(min = 2, max = 100)
    private String username;

    @NotBlank(message = "Email không được bỏ troosng")
    @Email(message = "Email không hợp lệ")
    @Column(name = "email")
    private String email;

    @NotBlank(message = "Password không đựược bỏ trống")
    @Column(name = "password")
    private String password;
}
