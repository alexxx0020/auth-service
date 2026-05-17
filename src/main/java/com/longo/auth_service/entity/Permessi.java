package com.longo.auth_service.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "PERMESSI")
public class Permessi {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID_PERMESSO")
    private UUID idPermesso;

    private String codice;

    private String description;
}
