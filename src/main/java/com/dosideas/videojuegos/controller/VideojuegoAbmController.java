package com.dosideas.videojuegos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author alopezorozco
 */
@Controller
public class VideojuegoAbmController {
    
    @RequestMapping("/videojuegos/crear")
    public String mostrarFormAlta(){
        return "formvideojuego.html";
    }
}
