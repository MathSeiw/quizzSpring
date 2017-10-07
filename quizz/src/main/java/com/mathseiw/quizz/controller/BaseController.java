package com.mathseiw.quizz.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
@SessionAttributes("user")
public class BaseController {

    @Autowired
    private User user;
    
    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("index", "user", user);
    }
    @RequestMapping(value = "/start",method = RequestMethod.POST)
    public String requestDone(@Valid @ModelAttribute("user")User user,BindingResult bindingResult,final ModelMap pModel) {
        if (bindingResult.hasErrors()) {
            return "index";
        }
        return "success";
    }
}