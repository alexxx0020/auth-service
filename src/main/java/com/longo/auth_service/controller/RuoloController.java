package com.longo.auth_service.controller;

import com.longo.auth_service.dto.RuoloDto;
import com.longo.auth_service.dto.RuoloRequestDto;
import com.longo.auth_service.dto.RuoloWithListDto;
import com.longo.auth_service.interfaces.RuoloInterface;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/ruolo")
public class RuoloController {

    private final RuoloInterface ruoloInterface;

    @PostMapping
    public ResponseEntity<RuoloDto> addRole(@Valid @RequestBody RuoloRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ruoloInterface.addRole(dto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<RuoloDto>> getAllRoles() {
        return ResponseEntity.ok(ruoloInterface.getAllRoles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RuoloDto> getRoleById(@PathVariable UUID id) {
        return ResponseEntity.ok(ruoloInterface.getRoleById(id));
    }

    @GetMapping("/{id}/users")
    public ResponseEntity<RuoloWithListDto> getRoleWithUsers(@PathVariable UUID id) {
        return ResponseEntity.ok(ruoloInterface.getRoleWithList(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RuoloDto> updateRole(@PathVariable UUID id, @RequestBody RuoloRequestDto dto) {
        return ResponseEntity.ok(ruoloInterface.updateRole(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RuoloDto> deleteRole(@PathVariable UUID id) {
        return ResponseEntity.ok(ruoloInterface.deleteRole(id));
    }
}
