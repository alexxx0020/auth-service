package com.longo.auth_service.controller;

import com.longo.auth_service.dto.PermessiDto;
import com.longo.auth_service.dto.PermessiRequest;
import com.longo.auth_service.interfaces.PermessiInterface;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/permessi")
public class PermessiController {

    private final PermessiInterface permessiInterface;

    @PostMapping
    public ResponseEntity<PermessiDto> addPermesso(@Valid @RequestBody PermessiRequest dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(permessiInterface.addPermesso(dto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<PermessiDto>> getPermessi() {
        return ResponseEntity.ok(permessiInterface.getPermessi());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PermessiDto> getPermessoById(@PathVariable UUID id) {
        return ResponseEntity.ok(permessiInterface.getPermettoById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PermessiDto> updatePermesso(@PathVariable UUID id,@Valid @RequestBody PermessiRequest dto) {
        return ResponseEntity.ok(permessiInterface.updatePermesso(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PermessiDto> deletePermesso(@PathVariable UUID id) {
        return ResponseEntity.ok(permessiInterface.deletePermessoById(id));
    }
}
