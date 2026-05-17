package com.longo.auth_service.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "RUOLO_PERMESSI")
public class RuoloPermessi {

    @EmbeddedId
    private RolePermissionId rolePermissionId;

    @ManyToOne
    @MapsId("idRuolo")
    @JoinColumn(name = "ID_RUOLO")
    private Ruolo ruolo;

    @ManyToOne
    @MapsId("idPermesso")
    @JoinColumn(name = "ID_PERMESSO")
    private Permessi permessi;
}
