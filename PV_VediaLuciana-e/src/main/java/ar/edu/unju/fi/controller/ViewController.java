package ar.edu.unju.fi.controller;


import ar.edu.unju.fi.service.ComidaService;
import ar.edu.unju.fi.dto.ComidaDTO;
import ar.edu.unju.fi.model.Comida.Categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {

    @Autowired
    private ComidaService comidaService;

    // Página principal que lista todas las comidas
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("comidas", comidaService.getComidas());
        return "index";
    }

    // Página para agregar una nueva comida
    @GetMapping("/agregar-comida")
    public String viewAgregarComidaPage() {
        return "agregar-comida";
    }

    // Página para editar una comida existente
    @GetMapping("/editar-comida/{id}")
    public String viewEditarComidaPage(@PathVariable("id") Long id, Model model) {
        ComidaDTO comida = comidaService.getComidaById(id);
        model.addAttribute("comida", comida);
        return "editar-comida";
    }

    // Manejar la creación de una nueva comida (HTML Form -> POST)
    @PostMapping("/agregar-comida")
    public String agregarComida(ComidaDTO comidaDTO) {
        comidaService.createComida(comidaDTO);
        return "redirect:/";
    }

    // Manejar la edición de una comida existente (HTML Form -> POST)
    @PostMapping("/editar-comida/{id}")
    public String editarComida(@PathVariable("id") Long id, ComidaDTO comidaDTO) {
        comidaService.updateComida(id, comidaDTO);
        return "redirect:/";
    }

    // Filtrar comidas por categoría
    @GetMapping("/filtrar-categoria")
    public String filtrarPorCategoria(@RequestParam("categoria") String categoria, Model model) {
        model.addAttribute("comidas", comidaService.filterByCategoria(Categoria.valueOf(categoria)));
        return "index";
    }

    // Filtrar comidas por rango de precios
    @GetMapping("/filtrar-precio")
    public String filtrarPorPrecio(@RequestParam("min") double min, @RequestParam("max") double max, Model model) {
        model.addAttribute("comidas", comidaService.filterByPrecio(min, max));
        return "index";
    }
}
