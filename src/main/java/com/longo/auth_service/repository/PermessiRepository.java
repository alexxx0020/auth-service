package com.longo.auth_service.repository;

import com.longo.auth_service.entity.Permessi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PermessiRepository extends JpaRepository<Permessi, UUID> {
}
