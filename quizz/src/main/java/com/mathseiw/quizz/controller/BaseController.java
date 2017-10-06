package com.mathseiw.quizz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mathseiw.quizz.model.User;

@Controller
public class BaseController {

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("index", "user", new User());
    }
    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public ModelAndView requestDone(@ModelAttribute("User")User user,final ModelMap pModel) {
        user.setUsername( user.getUsername()+"-"+user.getUsername() );
        return new ModelAndView("index", "user", user);
    }
}