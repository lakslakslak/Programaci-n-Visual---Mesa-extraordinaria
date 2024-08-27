package ar.edu.unju.fi.controller;

import ar.edu.unju.fi.dto.ComidaDTO;
import ar.edu.unju.fi.model.Comida;
import ar.edu.unju.fi.service.ComidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comidas")
public class ComidaController {

    @Autowired
    private ComidaService comidaService;

    // Crear una nueva comida
    @PostMapping
    public ResponseEntity<ComidaDTO> createComida(@RequestBody ComidaDTO comidaDTO) {
        ComidaDTO nuevaComida = comidaService.createComida(comidaDTO);
        return new ResponseEntity<>(nuevaComida, HttpStatus.CREATED);
    }

    // Obtener todas las comidas
    @GetMapping
    public ResponseEntity<List<ComidaDTO>> getAllComidas() {
        List<ComidaDTO> comidas = comidaService.getComidas();
        return new ResponseEntity<>(comidas, HttpStatus.OK);
    }

    // Filtrar comidas por categoría
    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<ComidaDTO>> filterByCategoria(@PathVariable Categoria categoria) {
        List<ComidaDTO> comidas = comidaService.filterByCategoria(categoria);
        return new ResponseEntity<>(comidas, HttpStatus.OK);
    }

    // Filtrar comidas por rango de precios
    @GetMapping("/precio")
    public ResponseEntity<List<ComidaDTO>> filterByPrecio(
            @RequestParam double min, @RequestParam double max) {
        List<ComidaDTO> comidas = comidaService.filterByPrecio(min, max);
        return new ResponseEntity<>(comidas, HttpStatus.OK);
    }

    // Modificar una comida existente
    @PutMapping("/{codigo}")
    public ResponseEntity<ComidaDTO> updateComida(
            @PathVariable Long codigo, @RequestBody ComidaDTO comidaDTO) {
        ComidaDTO comidaActualizada = comidaService.updateComida(codigo, comidaDTO);
        return new ResponseEntity<>(comidaActualizada, HttpStatus.OK);
    }

    // Eliminar lógicamente una comida
    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deleteComida(@PathVariable Long codigo) {
        comidaService.deleteComida(codigo);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
