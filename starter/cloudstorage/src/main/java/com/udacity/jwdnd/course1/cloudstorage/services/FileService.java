package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.entity.User;
import com.udacity.jwdnd.course1.cloudstorage.mapper.FileMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class FileService {
    private FileMapper fileMapper;
    private UserService userService;

    public FileService(FileMapper fileMapper, UserService userService) {
        this.fileMapper = fileMapper;
        this.userService = userService;
    }

    public int insertFile(String fileName, String contentType, String fileSize, String fileData){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getPrincipal().toString();
        User user = userService.getUser(userName);
        return fileMapper.insertFile(fileName, contentType, fileSize, user.getUserId(), fileData);
    }
}
