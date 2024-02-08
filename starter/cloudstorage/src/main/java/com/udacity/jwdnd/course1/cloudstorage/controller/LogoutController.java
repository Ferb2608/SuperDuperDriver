package com.udacity.jwdnd.course1.cloudstorage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LogoutController {
    @PostMapping("/logout")
    public String logout(RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("logoutSuccess", true);
        return "redirect:/login?logout";
    }
}
