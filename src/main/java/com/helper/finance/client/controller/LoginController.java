package com.helper.finance.client.controller;

import com.helper.finance.client.form.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by dvas on 15.04.2016.
 */
@Controller
@RequestMapping("/")
public class LoginController {

    @RequestMapping(method = RequestMethod.GET)
    public String login(ModelMap modelMap){
        LoginForm loginForm = new LoginForm();
        modelMap.addAttribute("loginForm", loginForm);
        return "login";
    }

    @RequestMapping(path = "/auth", method = RequestMethod.POST)
    public void authenticate(){

    }
}
