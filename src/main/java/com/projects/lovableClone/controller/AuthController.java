package com.projects.lovableClone.controller;

import com.projects.lovableClone.dto.auth.*;
import com.projects.lovableClone.service.AuthService;
import com.projects.lovableClone.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
//@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE) we can use this as well to avoid using access specifiers like private and final in line 18 and 19
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signup(@RequestBody SignupRequest request)
    {
        return ResponseEntity.ok(authService.signup(request));
    }//ResponseEntity ---- used to return a response, we do not return an object as a response, there is a wrapper which acts as a body of that object

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }

    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> getProfile() {
        long userId = 1L;
        return ResponseEntity.ok(userService.getProfile(userId));
    }
}
