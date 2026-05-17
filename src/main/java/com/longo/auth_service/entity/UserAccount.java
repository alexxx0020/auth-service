package com.longo.auth_service.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@NoArgsConstructor
@Table(name = "USER_ACCOUNT")
@Entity
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ACCOUNT_ID")
    private UUID accountId;

    private String email;
    private String username;
    private String password;

    @ManyToOne
    @JoinColumn(name = "id_ruolo")
    private Ruolo ruolo;

    @Column(name = "DATA_REGISTRAZIONE")
    private Timestamp dataRegistrazione;

    @Column(name = "IS_ACTIVE")
    private boolean isActive;
}
