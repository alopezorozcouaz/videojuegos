package com.dosideas.videojuegos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author alopezorozco
 */
@Controller
public class ListadoController {
    
    @RequestMapping("/")
    public String listarVideojuegos(){
        // busqueda de los videojuegos
        return "listado";
    }
}
