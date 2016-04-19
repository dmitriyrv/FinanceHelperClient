package com.helper.finance.client.service;

import com.helper.finance.client.form.LoginForm;

/**
 * Created by dvas on 18.04.2016.
 */
public interface LoginService {
    LoginForm getLogin(String email);
}
