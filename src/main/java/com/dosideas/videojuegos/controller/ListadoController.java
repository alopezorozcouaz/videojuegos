package com.dosideas.videojuegos.controller;

import com.dosideas.videojuegos.domain.Videojuego;
import com.dosideas.videojuegos.service.VideojuegoService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author alopezorozco
 */
@Controller
public class ListadoController {
    
    private final VideojuegoService videojuegoService;

    public ListadoController(VideojuegoService videojuegoService) {
        this.videojuegoService = videojuegoService;
    }    
    
    @RequestMapping("/")
    public String listarVideojuegos(Model model){
        List<Videojuego> destacados = videojuegoService.buscarDestacados();
        
        model.addAttribute("videojuegos", destacados);
        
        return "listado.html";
    }
}
