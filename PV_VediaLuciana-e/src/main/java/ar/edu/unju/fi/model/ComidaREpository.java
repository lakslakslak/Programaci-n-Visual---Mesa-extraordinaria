package ar.edu.unju.fi.model;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComidaREpository extends JpaRepository<Comida, Long> {
    List<Comida> findByCategoria(String categoria);
    List<Comida> findByPrecioBetween(double minPrecio, double maxPrecio);
    List<Comida> findByDisponibleTrue();
}
