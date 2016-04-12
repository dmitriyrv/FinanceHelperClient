package com.helper.finance.client.service;

import com.helper.finance.client.dto.UserDto;

import java.io.IOException;

/**
 * Created by dvas on 12.04.2016.
 */
public interface UserService {
    UserDto createUser(UserDto newUser) throws IOException;
}
