package com.dosideas.videojuegos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author alopezorozco
 */
@Controller
public class MainController {
    
    @GetMapping("/")
    public String home(){
        return "home";
    }
    
    @GetMapping("/login")
    public String login(){
        return "login";
    }   
}
