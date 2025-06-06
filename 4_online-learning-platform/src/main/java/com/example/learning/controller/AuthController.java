package com.example.learning.controller;

import com.example.learning.model.Role;
import com.example.learning.model.User;
import com.example.learning.security.JwtUtil;
import com.example.learning.service.UserService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        try {
            User user = userService.registerUser(request.getUsername(), request.getPassword(), Role.USER);
            return ResponseEntity.ok("User registered with username: " + user.getUsername());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        return userService.authenticate(request.getUsername(), request.getPassword())
                .map(user -> {
                    String token = jwtUtil.generateToken(user.getUsername());
                    return ResponseEntity.ok(new AuthResponse(token));
                })
                .orElseGet(() -> ResponseEntity.status(401).body("Invalid username or password"));
    }

    @Data
    static class RegisterRequest {
        private String username;
        private String password;
    }

    @Data
    static class LoginRequest {
        private String username;
        private String password;
    }

    @Data
    static class AuthResponse {
        private final String token;
    }
}
