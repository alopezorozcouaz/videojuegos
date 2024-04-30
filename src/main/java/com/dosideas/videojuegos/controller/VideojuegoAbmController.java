package com.dosideas.videojuegos.controller;

import com.dosideas.videojuegos.domain.Videojuego;
import com.dosideas.videojuegos.service.DistribuidorService;
import com.dosideas.videojuegos.service.VideojuegoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author alopezorozco
 */
@Controller
public class VideojuegoAbmController {
    private final DistribuidorService distribuidorService;
    private final VideojuegoService videojuegoService;

    public VideojuegoAbmController(DistribuidorService distribuidorService,
            VideojuegoService videojuegoService) {
        this.distribuidorService = distribuidorService;
        this.videojuegoService = videojuegoService;
    }
    
    @RequestMapping("/videojuegos/crear")
    public String mostrarFormAlta(Model model){
        model.addAttribute("distribuidores", distribuidorService.buscarTodos());
        model.addAttribute("videojuego", new Videojuego());
        return "formvideojuego.html";
    }
    
    /**
     * Inserta un nuevo videojuego
     * @param videojuego
     * @return 
     */
    @PostMapping("/videojuegos/guardar")
    public String guardar(Videojuego videojuego){
        videojuegoService.guardar(videojuego);
        return "redirect:/";
    }
}
