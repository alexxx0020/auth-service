package com.longo.auth_service.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Data
@NoArgsConstructor
public class RolePermissionId implements Serializable {

    @Column(name = "ID_RUOLO")
    private UUID idRuolo;

    @Column(name = "ID_PERMESSO")
    private UUID idPermesso;
}
