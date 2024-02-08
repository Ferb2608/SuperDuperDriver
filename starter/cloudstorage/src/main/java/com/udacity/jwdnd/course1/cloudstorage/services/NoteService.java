package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.entity.Note;
import com.udacity.jwdnd.course1.cloudstorage.entity.User;
import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    private NoteMapper noteMapper;
    private UserService userService;

    public NoteService(NoteMapper noteMapper, UserService userService) {
        this.noteMapper = noteMapper;
        this.userService = userService;
    }

    public int creatNote(Note note){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getPrincipal().toString();
        User user = userService.getUser(userName);
        return noteMapper.insert(note, user);
    }
    public List<Note> findAllNotes(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getPrincipal().toString();
        User user = userService.getUser(userName);
        return noteMapper.findAllNotes(user.getUserId());
    }
    public void deleteNote(Integer noteId){
        noteMapper.deleteNote(noteId);
    }

    public void updateNote(Integer noteId, String noteTitle, String noteDescription){
        noteMapper.updateNote(noteId, noteTitle, noteDescription);
    }
}
