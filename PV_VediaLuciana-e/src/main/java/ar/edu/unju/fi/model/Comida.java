package ar.edu.unju.fi.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@EntityScan
public class Comida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(nullable = false)
    private String nombre;

    private String descripcion;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    private double precio;

    private LocalDate fechaAlta;

    private String foto;

    private boolean estado;

    // Constructor vacío
    public Comida() {
        this.fechaAlta = LocalDate.now(); // Inicializa la fecha de alta con la fecha actual
        this.estado = true; // Inicializa el estado como activo
    }

    // Constructor con parámetros
    public Comida(String nombre, String descripcion, Categoria categoria, double precio, String foto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.precio = precio;
        this.fechaAlta = LocalDate.now(); // Fecha de alta actual
        this.foto = foto;
        this.estado = true; // Estado activo
    }

    // Getters y setters
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    // Método para realizar la eliminación lógica
    public void eliminarLogicamente() {
        this.estado = false;
    }
    
 // Enumeración para las categorías de comida
    public enum Categoria {
        ENTRADA, PLATO_PRINCIPAL, POSTRE
    }
}