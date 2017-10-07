package com.mathseiw.quizz.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import org.apache.log4j.Logger;

import com.mathseiw.quizz.model.User;

@Controller
@SessionAttributes("user")
public class BaseController {

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("index", "user", new User());
    }
    @RequestMapping(value = "/start",method = RequestMethod.POST)
    public String requestDone(@Valid @ModelAttribute("user")User user,BindingResult bindingResult,final ModelMap pModel) {
        if (bindingResult.hasErrors()) {
            return "index";
        }
        return "success";
    }
}