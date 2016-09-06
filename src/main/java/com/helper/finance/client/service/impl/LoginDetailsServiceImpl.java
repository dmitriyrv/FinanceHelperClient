package com.helper.finance.client.service.impl;

import com.helper.finance.client.form.LoginForm;
import com.helper.finance.client.form.enums.LoginRolesEnum;
import com.helper.finance.client.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dvas on 18.04.2016.
 */
@Service
public class LoginDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private LoginService loginService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        LoginForm loginForm = loginService.getLogin("admin");

        Set<GrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority("USER"));

        UserDetails userDetails = new User(loginForm.getEmail(),loginForm.getPassword(),roles);

        return userDetails;
    }
}
