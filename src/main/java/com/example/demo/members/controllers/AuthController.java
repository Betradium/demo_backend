package com.example.demo.members.controllers;

import com.example.demo.members.model.LoginRequest;
import com.example.demo.members.model.LoginResponse;
import com.example.demo.members.model.Member;
import com.example.demo.members.services.AuthService;
import com.example.demo.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody @Validated LoginRequest loginRequest) {
        return authService.attemptLogin(loginRequest.getEmail(), loginRequest.getPassword());
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerMember(@RequestBody Member member) {
        return authService.registerMember(member);
    }

    @GetMapping("/authorized")
    public String authorized(@AuthenticationPrincipal UserPrincipal userPrincipal) {
        return userPrincipal.getEmail() + " is authorized";
    }
}