package com.longo.auth_service.repository;

import com.longo.auth_service.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserAccount, UUID> {
}
