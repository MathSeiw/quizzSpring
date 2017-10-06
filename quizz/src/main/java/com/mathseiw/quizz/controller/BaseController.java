package com.mathseiw.quizz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class BaseController {

    @RequestMapping(method = RequestMethod.GET)
    public String afficherBonjour(final ModelMap pModel) {
        pModel.addAttribute("personne", "Regis");
        return "index";
    }
}