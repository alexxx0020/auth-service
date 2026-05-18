package com.longo.auth_service.interfaces;

import com.longo.auth_service.dto.PermessiDto;
import com.longo.auth_service.dto.PermessiRequest;

import java.util.List;
import java.util.UUID;

public interface PermessiInterface {

    PermessiDto addPermesso(PermessiRequest permessiRequest);
    List<PermessiDto> getPermessi();
    PermessiDto getPermettoById(UUID id);
    PermessiDto updatePermesso(UUID id, PermessiRequest permessiRequest);
    PermessiDto deletePermessoById(UUID id);

}
