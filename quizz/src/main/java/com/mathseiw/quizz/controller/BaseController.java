package com.mathseiw.quizz.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.mathseiw.quizz.model.User;

@Controller
@SessionAttributes("User")
public class BaseController {
    
    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("index", "user", new User());
    }
    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public ModelAndView requestDone(@Valid @ModelAttribute("user")User user,BindingResult bindingResult,final ModelMap pModel) {
        user.setUsername( user.getUsername()+"-"+user.getUsername() );
        if (bindingResult.hasErrors()) {
            return new ModelAndView("index2", "user", user);
        }
        return new ModelAndView("index", "user", user);
    }
}