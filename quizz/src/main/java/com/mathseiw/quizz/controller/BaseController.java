package com.mathseiw.quizz.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mathseiw.quizz.model.Quizz;
import com.mathseiw.quizz.model.User;

@Controller
@SessionAttributes("user")
public class BaseController {

    @Autowired
    private User user;
    @Autowired
    private Quizz quizz;
    
    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);
    
    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("index", "user", user);
    }
    @RequestMapping(value = "/inscription",method = RequestMethod.POST)
    public String requestDone(@Valid @ModelAttribute("user")User user,BindingResult bindingResult, 
            RedirectAttributes redirectAttributes,final ModelMap pModel) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.user", bindingResult);
            redirectAttributes.addFlashAttribute("user", user);
            //https://stackoverflow.com/questions/7755601/detect-session-expired-or-session-timeout-using-spring3
            return "redirect:/start";
        }
        return "success";
    }
    @RequestMapping(value = "/quizz",method = RequestMethod.GET)
    public String quizz(Model model) {
        System.out.println(user);
        System.out.println(user.getUsername());
        model.addAttribute("quizz", quizz);
        model.addAttribute("user", user);
        return "quizz";
    }
    
    @RequestMapping(value = "/verifquizz",method = RequestMethod.POST)
    public ModelAndView verifquizz(@ModelAttribute("quizz")Quizz quizz,BindingResult bindingResult,final ModelMap pModel) {
        for(String value : quizz.getListreponses()){
            System.out.println(value);
        }
        return new ModelAndView("repquizz", "quizz", quizz);
    }
}