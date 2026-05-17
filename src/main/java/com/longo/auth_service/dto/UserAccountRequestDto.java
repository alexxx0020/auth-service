package com.longo.auth_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@NoArgsConstructor
public class UserAccountRequestDto {

    @NotBlank(message = "La mail è obbligatoria")
    private String email;

    @NotBlank(message = "Lo username è obbligatorio")
    private String username;

    @NotBlank(message = "La password è obbligatoria")
    private String password;

    @NotNull(message = "Il ruolo è obbligatorio")
    private UUID ruolo;

    @NotNull
    private boolean isActive;
}
