package com.helper.finance.client.controller;

import com.helper.finance.client.dto.UserDto;
import com.helper.finance.client.form.UserForm;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/")
public class UserController {

    @Autowired
    DozerBeanMapperFactoryBean dozerBeanMapperFactoryBean;

    @Autowired
    Mapper mapper;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user(ModelMap modelMap) {

        UserForm userForm = new UserForm();
        modelMap.addAttribute("userForm", userForm);
        return "adduser";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@Valid UserForm userForm, BindingResult result, ModelMap model) throws Exception {

        if (result.hasErrors()) {
            return "adduser";
        }

        mapper = dozerBeanMapperFactoryBean.getObject();
        UserDto userDto = new UserDto();

        mapper.map(userForm, userDto, "user");

        model.addAttribute("theObject", userDto.toString());
        return "creationsuccess";

    }
}
