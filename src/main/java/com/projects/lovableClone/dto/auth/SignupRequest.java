package com.projects.lovableClone.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record SignupRequest(
        @Email @NotBlank String email,
        @Size(min = 1, max = 30) String name,
        @NotBlank @Size(min = 8, max = 20)
        @Pattern(
                regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\\\d)(?=.*[@#$%^&+=!]).{8,20}$",
                message = "Password must be 8-20 characters long and contain at least one uppercase letter, one lowercase letter, one digit, and one special character."
        )
        String password
) {
}
