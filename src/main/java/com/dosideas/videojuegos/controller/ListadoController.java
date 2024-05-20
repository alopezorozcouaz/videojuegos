package com.dosideas.videojuegos.controller;

import com.dosideas.videojuegos.domain.Videojuego;
import com.dosideas.videojuegos.service.VideojuegoService;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    
    @RequestMapping("/listado")
    public String listarVideojuegos(Model model){
        List<Videojuego> destacados = videojuegoService.buscarDestacados();
        
        model.addAttribute("videojuegos", destacados);
        
        return "listado.html";
    }
    
    /**
     * Retorna la lista de videojuegos en formato JSON
     * @return 
     */
    @GetMapping("/videojuegos")
    @ResponseBody
    public ResponseEntity<List<Videojuego>> getVideojuegos(){
        List<Videojuego> todos = videojuegoService.buscarDestacados();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }
    
    
    /**
     * Retorna una lista de elementos según el distribuidor
     * @param distribuidorId
     * @param model
     * @return 
     */
    @RequestMapping("/videojuegosPorDistribuidor")
    public String listarVideojuegosPorDistribuidor(int distribuidorId, Model model){
        List<Videojuego> juegos = videojuegoService.buscarPorDistribuidor(distribuidorId);
        model.addAttribute("videojuegos", juegos);
        return "listado.html";
    }
    
    /**
     * Permite realizar búsquedas de videojuegos por el nombre
     * @param consulta
     * @param model
     * @return 
     */
    @RequestMapping("/buscar")
    public String buscar(@RequestParam("q") String consulta, Model model){
        List<Videojuego> juegos = videojuegoService.buscar(consulta);
        model.addAttribute("videojuegos", juegos);
        return "listado.html";
    }
    
    /**
     * Maneja la solicitud para buscar un videojuego por su ID.
     * @param idVideojuego El ID del videojuego a buscar.
     * @param model El modelo para agregar atributos para la vista.
     * @return La vista que mostrará los detalles del videojuego o una página de error.
     */
    @RequestMapping("/buscarVideojuegoPorId")
    public String buscarVideojuegoPorId(@RequestParam("videojuegoId") String idVideojuego, Model model){
        String mensajeError = "";
        
        try{
            // Intenta convertir el ID del videojuego a un entero
            int id = Integer.parseInt(idVideojuego);
            
            // Busca el videojuego por su ID
            Optional<Videojuego> opcionalVideojuego = videojuegoService.buscarPorId(id);

            if (opcionalVideojuego.isPresent()){
                // Si el videojuego se encuentra, lo agrega al modelo y muestra la vista del videojuego
                Videojuego videojuego = opcionalVideojuego.get();
                model.addAttribute("videojuego", videojuego);
                return "videojuego.html";
            }else{
                // Si el videojuego no se encuentra, muestra una página de error con el mensaje correspondiente
                mensajeError = "Videojuego no encontrado";
                model.addAttribute("mensajeError", mensajeError);
                return "error";
            } 
        }catch(NumberFormatException e){
            // Si ocurre una excepción al convertir el ID a entero, muestra una página de error con el mensaje correspondiente
            mensajeError = "Id. del videojuego inválido";
            model.addAttribute("mensajeError", mensajeError);
            return "error";
        }      
    }
}
