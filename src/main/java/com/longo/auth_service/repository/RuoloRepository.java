package com.longo.auth_service.repository;

import com.longo.auth_service.entity.Ruolo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RuoloRepository extends JpaRepository<Ruolo, UUID> {
}
