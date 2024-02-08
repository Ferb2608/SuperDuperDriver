package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.entity.Note;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NoteController {
    private NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping("/newNote")
    public String newNote(@ModelAttribute Note note, Model model){
        if(note.getNoteId() == null){
            int result = noteService.creatNote(note);
            if(result != 0){
                model.addAttribute("success", true);
            } else{
                model.addAttribute("failure", true);
            }
        } else{
            noteService.updateNote(note.getNoteId(), note.getNoteTitle(), note.getNoteDescription());
            model.addAttribute("success", true);
        }

        return "result";
    }
    @GetMapping("/deleteNote/{id}")
    public String deleteNote(@PathVariable("id") Integer noteId, Model model){
        noteService.deleteNote(noteId);
        model.addAttribute("success", true);
        return "result";
    }
}
