package com.longo.auth_service.service;

import com.longo.auth_service.dto.RuoloDto;
import com.longo.auth_service.dto.RuoloRequestDto;
import com.longo.auth_service.dto.RuoloWithListDto;
import com.longo.auth_service.entity.Ruolo;
import com.longo.auth_service.exception.RequestNotValidException;
import com.longo.auth_service.interfaces.RuoloInterface;
import com.longo.auth_service.repository.RuoloRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RuoloService implements RuoloInterface{

    private final RuoloRepository ruoloRepository;
    private final ModelMapper modelMapper;

    @Override
    public RuoloDto addRole(RuoloRequestDto dto) {
        return modelMapper.map(
                ruoloRepository.save(modelMapper.map(dto, Ruolo.class)),
                RuoloDto.class );
    }

    @Override
    public List<RuoloDto> getAllRoles() {
        return ruoloRepository.findAll().stream()
                .map(r -> modelMapper.map(r, RuoloDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<RuoloWithListDto> getAllRolesWithList() {
        return ruoloRepository.findAll().stream().
                map(r -> modelMapper.map(r, RuoloWithListDto.class))
                .toList();
    }

    @Override
    @Transactional
    public RuoloWithListDto getRoleWithList(UUID id) {
        Ruolo ruolo = ruoloRepository.findById(id).orElseThrow(
                () -> new RequestNotValidException("Nessun elemento presente con questo id: " + id));

        return modelMapper.map(ruolo, RuoloWithListDto.class);
    }

    @Override
    public RuoloDto updateRole(UUID id, RuoloRequestDto ruoloRequestDto) {
        Ruolo ruolo = ruoloRepository.findById(id).orElseThrow(
                () -> new RequestNotValidException("Nessun elemento presente con questo id: " + id));

        ruolo.setNome(ruoloRequestDto.getNome());

        Ruolo saved = ruoloRepository.save(ruolo);

        return modelMapper.map(saved, RuoloDto.class);
    }

    @Override
    @Transactional
    public RuoloDto deleteRole(UUID id) {
        Ruolo found = ruoloRepository.findById(id).orElseThrow(
                () -> new RequestNotValidException("Nessun elemento presente con questo id: " + id));

        if (!found.getUsers().isEmpty()){
            throw new RequestNotValidException("Impossibile completare la richiesta, sono presenti" +
                    " " + found.getUsers().size() + " relazioni attive. Rimuovile prima di procedere");
        }

        ruoloRepository.delete(found);

        return modelMapper.map(found, RuoloDto.class);
    }

    @Override
    public RuoloDto getRoleById(UUID id) {
        Ruolo ruolo = ruoloRepository.findById(id).orElseThrow(
                () -> new RequestNotValidException("Nessun elemento presente con questo id: " + id));

        return modelMapper.map(ruolo, RuoloDto.class);
    }
}

