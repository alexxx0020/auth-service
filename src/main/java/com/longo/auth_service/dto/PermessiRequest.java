package com.longo.auth_service.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PermessiRequest {

    @NotBlank(message = "Il codice è obbligatorio")
    private String codice;

    @NotBlank(message = "La descrizione è obbligatoria")
    private String description;
}
