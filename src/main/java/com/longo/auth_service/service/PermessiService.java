package com.longo.auth_service.service;

import com.longo.auth_service.dto.PermessiDto;
import com.longo.auth_service.dto.PermessiRequest;
import com.longo.auth_service.entity.Permessi;
import com.longo.auth_service.exception.RequestNotValidException;
import com.longo.auth_service.interfaces.PermessiInterface;
import com.longo.auth_service.repository.PermessiRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PermessiService implements PermessiInterface {

    private final ModelMapper modelMapper;
    private final PermessiRepository permessiRepository;

    @Override
    public PermessiDto addPermesso(PermessiRequest permessiRequest) {
        Permessi permessi = modelMapper.map(permessiRequest, Permessi.class);

        Permessi saved = permessiRepository.save(permessi);

        return modelMapper.map(saved, PermessiDto.class);
    }

    @Override
    public List<PermessiDto> getPermessi() {
        return permessiRepository.findAll().stream()
                .map(p -> modelMapper.map(p, PermessiDto.class))
                .toList();
    }

    @Override
    public PermessiDto getPermettoById(UUID id) {
        Permessi found = permessiRepository.findById(id).orElseThrow(
                () -> new RequestNotValidException("Nessun elemento presente con questo id: " + id)
        );

        return modelMapper.map(found, PermessiDto.class);
    }

    @Override
    public PermessiDto updatePermesso(UUID id, PermessiRequest permessiRequest) {
        Permessi found = permessiRepository.findById(id).orElseThrow(
                () -> new RequestNotValidException("Nessun elemento presente con questo id: " + id)
        );

        found.setCodice(permessiRequest.getCodice());
        found.setDescription(permessiRequest.getDescription());

        Permessi saved = permessiRepository.save(found);

        return modelMapper.map(saved, PermessiDto.class);
    }

    @Override
    public PermessiDto deletePermessoById(UUID id) {
        Permessi found = permessiRepository.findById(id).orElseThrow(
                () -> new RequestNotValidException("Nessun elemento presente con id: " + id)
        );

        permessiRepository.delete(found);

        return modelMapper.map(found, PermessiDto.class);
    }
}
