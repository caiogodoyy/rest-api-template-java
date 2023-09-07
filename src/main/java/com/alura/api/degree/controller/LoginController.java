package com.alura.api.degree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alura.api.degree.domain.user.User;
import com.alura.api.degree.dto.user.UserLoginData;
import com.alura.api.degree.dto.user.UserToken;
import com.alura.api.degree.infra.security.TokenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class LoginController {
    
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    TokenService tokenService;

    @PostMapping
    public ResponseEntity<UserToken> login(@RequestBody @Valid UserLoginData data) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        var userAuthentication = authenticationManager.authenticate(authenticationToken);

        var token = tokenService.createToken((User) userAuthentication.getPrincipal());

        return ResponseEntity.ok(new UserToken(token));
    }

}