package com.longo.auth_service.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RuoloRequestDto {

    @NotBlank(message = "Il nome è obbligatorio")
    private String nome;
}
