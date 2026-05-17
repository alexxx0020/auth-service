package com.longo.auth_service.interfaces;

import com.longo.auth_service.dto.UserAccountDto;
import com.longo.auth_service.dto.UserAccountRequestDto;

import java.util.List;
import java.util.UUID;

public interface UserAccountInterface {

    UserAccountDto addUser(UserAccountRequestDto userAccountRequestDto);
    List<UserAccountDto> getAllUsers();
    UserAccountDto getUserById(UUID id);
    UserAccountDto deleteUserById(UUID id);
    UserAccountDto updateUser(UUID id, UserAccountRequestDto userAccountRequestDto);
}
