package ar.edu.unju.fi.dto;

import ar.edu.unju.fi.model.Comida.Categoria;
import ar.edu.unju.fi.model.Comida;
import java.time.LocalDate;


//Importa los paquetes necesarios

public class ComidaDTO {

 private Long id; // Identificador único para la comida
 private String nombre; // Nombre de la comida
 private String descripcion; // Descripción de la comida
 private Categoria categoria; // Categoría de la comida
 private double precio; // Precio de la comida
 private String imagenUrl; // URL de la imagen de la comida
 private boolean disponible; // Disponibilidad de la comida
 private String fecha; // Fecha asociada (puede ser de creación o de actualización)

 // Constructor completo que coincide con los parámetros mencionados
 public ComidaDTO(Long id, String nombre, String descripcion, Categoria categoria, double precio, String imagenUrl, boolean disponible, String fecha) {
     this.id = id;
     this.nombre = nombre;
     this.descripcion = descripcion;
     this.categoria = categoria;
     this.precio = precio;
     this.imagenUrl = imagenUrl;
     this.disponible = disponible;
     this.fecha = fecha;
 }

 // Constructor sin parámetros
 public ComidaDTO() {
 }

 // Getters y Setters para cada atributo

 public Long getId() {
     return id;
 }

 public void setId(Long id) {
     this.id = id;
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

 public String getImagenUrl() {
     return imagenUrl;
 }

 public void setImagenUrl(String imagenUrl) {
     this.imagenUrl = imagenUrl;
 }

 public boolean isDisponible() {
     return disponible;
 }

 public void setDisponible(boolean disponible) {
     this.disponible = disponible;
 }

 public String getFecha() {
     return fecha;
 }

 public void setFecha(String fecha) {
     this.fecha = fecha;
 }

public Object isActivo() {
	// TODO Auto-generated method stub
	return null;
}
}
