package com.ileaje.ileajeapi.controller;

import com.ileaje.ileajeapi.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> body) {
        String user = body.get("email");
        String token = jwtUtil.generateToken(user);
        return Map.of("token", token);
    }
}
