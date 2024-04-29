package com.dosideas.videojuegos.controller;

import com.dosideas.videojuegos.service.DistribuidorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author alopezorozco
 */
@Controller
public class VideojuegoAbmController {
    private final DistribuidorService distribuidorService;

    public VideojuegoAbmController(DistribuidorService distribuidorService) {
        this.distribuidorService = distribuidorService;
    }
    
    @RequestMapping("/videojuegos/crear")
    public String mostrarFormAlta(Model model){
        model.addAttribute("distribuidores", distribuidorService.buscarTodos());
        return "formvideojuego.html";
    }
}
