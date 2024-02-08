package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.entity.User;
import com.udacity.jwdnd.course1.cloudstorage.services.FileService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Controller
public class FileController {
    private UserService userService;
    private FileService fileService;

    public FileController(UserService userService, FileService fileService) {
        this.userService = userService;
        this.fileService = fileService;
    }

    @PostMapping("/file-upload")
    public String uploadFile(@RequestParam("fileUpload") MultipartFile fileUpload, Model model) throws Exception {
        try {

            byte [] array = new byte[10000];
            InputStream fis = fileUpload.getInputStream();
            fis.read(array);
            String data = new String(array);
            fis.close();
            String fileSize = String.valueOf(fileUpload.getSize());
            int result = fileService.insertFile(fileUpload.getName(), fileUpload.getContentType(), fileSize, data);
            if(result != 0){
                model.addAttribute("success", true);
            } else{
                model.addAttribute("failure", true);
            }
        } catch (Exception e) {
            throw new Exception();
        }
        return "result";
    }
}
