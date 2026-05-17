package com.longo.auth_service.interfaces;

import com.longo.auth_service.dto.RuoloDto;
import com.longo.auth_service.dto.RuoloRequestDto;
import com.longo.auth_service.dto.RuoloWithListDto;

import java.util.List;
import java.util.UUID;

public interface RuoloInterface {

    RuoloDto addRole(RuoloRequestDto dto);
    List<RuoloDto> getAllRoles();
    List<RuoloWithListDto> getAllRolesWithList();
    RuoloWithListDto getRoleWithList(UUID id);
    RuoloDto updateRole(UUID id, RuoloRequestDto ruoloRequestDto);
    RuoloDto deleteRole(UUID id);
}
