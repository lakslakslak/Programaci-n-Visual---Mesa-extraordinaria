package ar.edu.unju.fi.service;

import ar.edu.unju.fi.model.Comida;
import ar.edu.unju.fi.dto.ComidaDTO;
import ar.edu.unju.fi.model.ComidaREpository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComidaService {

    @Autowired
    private ComidaREpository comidaREpository;

    // Crear una nueva comida
    public Comida createComida(ComidaDTO comidaDTO) {
        // Convertir ComidaDTO a Comida
        Comida comida = new Comida();
        comida.setNombre(comidaDTO.getNombre());
        comida.setDescripcion(comidaDTO.getDescripcion());
        comida.setCategoria(comidaDTO.getCategoria());
        comida.setPrecio(comidaDTO.getPrecio());
        comida.setActivo(comidaDTO.isActivo());
        // Guardar la entidad en el repositorio
        return comidaREpository.save(comida);
    }

    // Obtener todas las comidas
    public List<Comida> getAllComidas() {
        return comidaREpository.findAll();
    }

    // Obtener comida por id
    public Optional<Comida> getComidaById(Long id) {
        return comidaREpository.findById(id);
    }

    // Actualizar una comida existente
    public Comida updateComida(Long id, ComidaDTO comidaDTO) {
        // Buscar la comida existente
        Optional<Comida> existingComidaOpt = comidaREpository.findById(id);
        if (existingComidaOpt.isPresent()) {
            Comida comida = existingComidaOpt.get();
            comida.setNombre(comidaDTO.getNombre());
            comida.setDescripcion(comidaDTO.getDescripcion());
            comida.setCategoria(comidaDTO.getCategoria());
            comida.setPrecio(comidaDTO.getPrecio());
            comida.setActivo(comidaDTO.isActivo());
            // Guardar los cambios en el repositorio
            return comidaREpository.save(comida);
        }
        // Lanzar una excepción si no se encuentra la comida
        throw new RuntimeException("Comida no encontrada con id: " + id);
    }

    // Eliminar una comida por id
    public void deleteComida(Long id) {
        // Verificar si la comida existe antes de eliminar
        if (comidaREpository.existsById(id)) {
            comidaREpository.deleteById(id);
        } else {
            throw new RuntimeException("Comida no encontrada con id: " + id);
        }
    }
}
