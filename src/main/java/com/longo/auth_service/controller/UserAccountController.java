package com.longo.auth_service.controller;

import com.longo.auth_service.dto.UserAccountDto;
import com.longo.auth_service.dto.UserAccountRequestDto;
import com.longo.auth_service.interfaces.UserAccountInterface;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/user")
public class UserAccountController {

    private final UserAccountInterface userAccountInterface;

    @PostMapping
    public ResponseEntity<UserAccountDto> addUser(@Valid @RequestBody UserAccountRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userAccountInterface.addUser(dto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserAccountDto>> getAllUsers() {
        return ResponseEntity.ok(userAccountInterface.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserAccountDto> getUserById(@PathVariable UUID id) {
        return ResponseEntity.ok(userAccountInterface.getUserById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserAccountDto> updateUser(@PathVariable UUID id,@Valid @RequestBody UserAccountRequestDto dto) {
        return ResponseEntity.ok(userAccountInterface.updateUser(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserAccountDto> deleteUser(@PathVariable UUID id) {
        return ResponseEntity.ok(userAccountInterface.deleteUserById(id));
    }
}