package com.uybor.controller;

import com.uybor.payload.SignInDTO;
import com.uybor.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
@CrossOrigin
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signIn")
    public ResponseEntity<?> signIn(@RequestBody @Valid SignInDTO signInDTO) {
        return ResponseEntity.ok(authService.register(signInDTO));
    }

    @GetMapping("/greeting")
    public String getGreeting() {
        return "Hello";
    }


}
