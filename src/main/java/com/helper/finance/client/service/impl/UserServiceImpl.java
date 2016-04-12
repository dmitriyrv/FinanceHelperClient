package com.helper.finance.client.service.impl;

import com.helper.finance.client.dto.UserDto;
import com.helper.finance.client.service.ApacheHelper;
import com.helper.finance.client.service.UserService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by dvas on 12.04.2016.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    Properties serverProperties;

    @Autowired
    ObjectMapper mapper;

    @Autowired
    ApacheHelper apacheHelper;

    @Override
    public UserDto createUser(UserDto newUser) throws IOException {

        String serviceUrl = serverProperties.getProperty("server.url") + serverProperties.getProperty("server.service.user");

        String userDtoJson = apacheHelper.performPostRequest(serviceUrl, mapper.writeValueAsString(newUser));

        return mapper.readValue(userDtoJson, UserDto.class);
    }
}
