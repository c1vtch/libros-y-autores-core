package com.francisconavarrete.libros_y_autores.controladores;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorLibros {
    private static HashMap<String, String> listaLibros = new HashMap<String, String>();

    public ControladorLibros() {
	listaLibros.put("Odisea", "Homero");	
	listaLibros.put("Don Quijote de la Mancha", "Miguel de Cervantes");
	listaLibros.put("El Código Da Vinci", "Dan Brown");		
	listaLibros.put("Alicia en el país de las maravillas", "Lewis Carroll");
	listaLibros.put("El Hobbit", "J.R.R. Tolkien");	
	listaLibros.put("El alquimista", "Paulo Coelho");	
}

    @GetMapping("/")
    public String inicio(){
        return "inicio";
    }

    @GetMapping("/libros")
    public String obtenerTodosLosLibros(Model model){
        model.addAttribute("libros", listaLibros);
        return "libros";
    }

    @GetMapping("/libros/{nombre}")
    public String obtenerInformacionDeLibro(@PathVariable String nombre, Model model){
        boolean foundBook = false;
        for(Map.Entry<String, String> libro: listaLibros.entrySet()){
            String nombreLibro = libro.getKey();
            String autor = libro.getValue();
            if(nombreLibro.equals(nombre)){
                foundBook = true;
                model.addAttribute("foundBook", foundBook);
                model.addAttribute("nombreLibro", nombreLibro);
                model.addAttribute("autor", autor);
                break;
            }
        }

        return "detalleLibro";
    }

    @GetMapping("/libros/formulario")
    public String formularioLibro(){
        return "formularioLibros";
    }

    @PostMapping("/procesa/libro")
    public String procesaLibro(@RequestParam("titulo") String titulo, @RequestParam("autor") String autor){
        listaLibros.put(titulo, autor);
        return "redirect:/libros";
    }
}
