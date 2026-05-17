package com.longo.auth_service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class RuoloWithListDto {

    private UUID idRole;

    private String nome;

    private List<UserAccountDto> users;
}
