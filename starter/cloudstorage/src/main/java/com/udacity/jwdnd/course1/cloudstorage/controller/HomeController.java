package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private NoteService noteService;

    public HomeController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("home")
    public String homePage(Model model){
        model.addAttribute("allNotes", noteService.findAllNotes());
        return "home";
    }
}
