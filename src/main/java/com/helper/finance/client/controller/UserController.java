package com.helper.finance.client.controller;

import com.helper.finance.client.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by dvasd on 01.04.2016.
 */

@Controller
@RequestMapping("/")
public class UserController {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView user(){
        return new ModelAndView("adduser", "command", new UserDto());
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@Valid UserDto userDto, BindingResult result, ModelMap model){

        if (result.hasErrors()){
            return "adduser";
        }

        model.addAttribute("theObject", "The user");
        return "creationsuccess";

    }
}
