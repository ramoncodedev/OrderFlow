package com.ordemflow.ordemFlow.bussiness.controllers;


import com.ordemflow.ordemFlow.bussiness.DTOs.request.LoginRequest;
import com.ordemflow.ordemFlow.bussiness.DTOs.request.UserRequest;
import com.ordemflow.ordemFlow.bussiness.DTOs.response.LoginResponse;
import com.ordemflow.ordemFlow.bussiness.DTOs.response.UserResponse;
import com.ordemflow.ordemFlow.bussiness.mapper.UserMapper;
import com.ordemflow.ordemFlow.bussiness.service.UserService;
import com.ordemflow.ordemFlow.infrastructure.Entity.User;
import com.ordemflow.ordemFlow.infrastructure.config.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @PostMapping("/create")
    public ResponseEntity<UserResponse> create( @RequestBody UserRequest userRequest){
        User user = UserMapper.toConvertRequest(userRequest);
        User newUser = userService.registerUser(user);

        return ResponseEntity.status(HttpStatus.CREATED).body( UserMapper.toConvertResponse(newUser));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> create(@RequestBody LoginRequest loginRequest){
        UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password());

        Authentication authentication = authenticationManager.authenticate(userAndPass);

        User user = (User) authentication.getPrincipal();

        String token = tokenService.genereteToken(user);

        return ResponseEntity.ok(new LoginResponse(token));
        
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<UserResponse>> findAll(){
        List<User> users = userService.findAll();
        List<UserResponse> saveUser = users.stream().map(user -> UserMapper.toConvertResponse(user)).toList();

        return ResponseEntity.ok().body(saveUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById( @PathVariable Long id){
        User user = userService.findById(id);
        UserResponse response = UserMapper.toConvertResponse(user);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete( @PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
