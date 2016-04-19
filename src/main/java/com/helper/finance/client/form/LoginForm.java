package com.helper.finance.client.form;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by dvas on 15.04.2016.
 */
public class LoginForm {


    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

    public LoginForm(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public LoginForm() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
