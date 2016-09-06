package com.helper.finance.client.controller;

import com.helper.finance.client.dto.UserDto;
import com.helper.finance.client.form.UserForm;
import com.helper.finance.client.service.UserService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by dvasd on 01.04.2016.
 */

@Controller
//@PreAuthorize("hasRole('USER')")
@RequestMapping("/")
public class UserController {

    @Autowired
    Mapper mapper;

    @Autowired
    UserService userService;

   // @Secured({"USER"})
    @RequestMapping(method = RequestMethod.GET, value = "/user")
    public String user(ModelMap modelMap) {

        UserForm userForm = new UserForm();
        modelMap.addAttribute("userForm", userForm);
        return "adduser";
    }

   // @Secured({"USER"})
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@Valid UserForm userForm, BindingResult result, ModelMap model) throws Exception {

        if (result.hasErrors()) {
            return "adduser";
        }

        UserDto userDto = new UserDto();
        UserDto newUser;

        mapper.map(userForm, userDto, "user");

        newUser = userService.createUser(userDto);

        model.addAttribute("theObject", newUser.toString());
        return "creationsuccess";

    }
}
