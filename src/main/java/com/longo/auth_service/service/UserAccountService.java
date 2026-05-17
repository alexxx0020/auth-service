package com.longo.auth_service.service;

import com.longo.auth_service.dto.UserAccountDto;
import com.longo.auth_service.dto.UserAccountRequestDto;
import com.longo.auth_service.entity.Ruolo;
import com.longo.auth_service.entity.UserAccount;
import com.longo.auth_service.exception.RequestNotValidException;
import com.longo.auth_service.interfaces.UserAccountInterface;
import com.longo.auth_service.repository.RuoloRepository;
import com.longo.auth_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserAccountService implements UserAccountInterface {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final RuoloRepository ruoloRepository;


    @Override
    @Transactional
    public UserAccountDto addUser(UserAccountRequestDto userAccountRequestDto) {
        UserAccount userAccount = modelMapper.map(userAccountRequestDto, UserAccount.class);
        userAccount.setDataRegistrazione(Timestamp.valueOf(LocalDateTime.now()));

        Ruolo role = ruoloRepository.findById(userAccountRequestDto.getRuolo()).orElseThrow(
                () -> new RequestNotValidException("Nessun Ruolo presente con l'id passato")
        );
        userAccount.setRuolo(role);

        UserAccount saved = userRepository.save(userAccount);

        return modelMapper.map(saved, UserAccountDto.class);
    }

    @Override
    public List<UserAccountDto> getAllUsers() {
        return List.of();
    }

    @Override
    public UserAccountDto getUserById(UUID id) {
        return null;
    }

    @Override
    public UserAccountDto deleteUserById(UUID id) {
        return null;
    }

    @Override
    public UserAccountDto updateUser(UUID id, UserAccountRequestDto userAccountRequestDto) {
        return null;
    }
}
