package com.longo.auth_service.dto;

import com.longo.auth_service.entity.Ruolo;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@NoArgsConstructor
public class UserAccountDto {

    private UUID accountId;

    private String email;
    private String username;
    private UUID ruolo;

    private Timestamp dataRegistrazione;

    private boolean isActive;
}
