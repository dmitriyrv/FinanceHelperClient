package com.helper.finance.client.controller;

import com.helper.finance.client.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by dvasd on 01.04.2016.
 */

@Controller
public class UserController {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView user(){
        return new ModelAndView("adduser", "command", new UserDto());
    }
}
