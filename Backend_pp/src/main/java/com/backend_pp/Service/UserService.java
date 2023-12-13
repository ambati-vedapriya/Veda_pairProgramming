package com.backend_pp.Service;

import com.backend_pp.Dto.UserDto;
import com.backend_pp.Dto.UserSensitiveDto;

import java.util.List;

public interface UserService {
    List<UserSensitiveDto> getAllUsers();

    UserSensitiveDto createUser(UserDto userDto);

}
