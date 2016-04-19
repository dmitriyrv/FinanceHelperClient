package com.helper.finance.client.service.impl;

import com.helper.finance.client.form.LoginForm;
import com.helper.finance.client.service.LoginService;
import org.springframework.stereotype.Service;

/**
 * Created by dvas on 18.04.2016.
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public LoginForm getLogin(String email) {
        LoginForm loginForm = new LoginForm();
        loginForm.setEmail(email);
        loginForm.setPassword("7110eda4d09e062aa5e4a390b0a572ac0d2c0220");
        return loginForm;
    }
}
