package com.longo.auth_service.repository;

import com.longo.auth_service.entity.RolePermissionId;
import com.longo.auth_service.entity.RuoloPermessi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RuoloPermessiRepository extends JpaRepository<RuoloPermessi, RolePermissionId> {
}
