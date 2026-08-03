package com.projects.lovableClone.dto.auth;

import jakarta.validation.constraints.*;

public record LoginRequest(
        @Email @NotBlank String email,

        @NotBlank @Size(min = 8, max = 20)
        @Pattern(
                regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\\\d)(?=.*[@#$%^&+=!]).{8,20}$",
                message = "Password must be 8-20 characters long and contain at least one uppercase letter, one lowercase letter, one digit, and one special character."
        )
        String password
) {
}

/*
  Regex          	Meaning
(?=.*[a-z])	        At least one lowercase letter
(?=.*[A-Z])	        At least one uppercase letter
(?=.*\\d)	        At least one digit
(?=.*[@#$%^&+=!])	At least one special character from the given set
.{8,20}         	Total length between 8 and 20 characters

*/
