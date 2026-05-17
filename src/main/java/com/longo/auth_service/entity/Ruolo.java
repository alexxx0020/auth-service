package com.longo.auth_service.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@Table(name = "RUOLO")
@Entity
public class Ruolo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID_ROLE")
    private UUID idRole;

    private String nome;

    @OneToMany(mappedBy = "ruolo", fetch = FetchType.LAZY)
    private List<UserAccount> users;
}
