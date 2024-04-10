package com.dosideas.videojuegos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ListadoController {
    
    @RequestMapping("/")
    public String listarVideojuegos(){
        //busqueda de los videojuegos
        return "listado";
    }
}
