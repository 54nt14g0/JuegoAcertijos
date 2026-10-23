package org.santi.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Acertijo {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private String descripcion;

    @Column
    private String imagenAcertijo;

    @Column
    private int cantidadRespuestas;

    // Aquí se define si el acertijo es de seleccion multiple, es de respuesta escrita
    // O es de seleccion múltiple con múltiples respuestas
    // Se pudo usar un ENUM, pero en este diseño se utilizó un STRING
    @Column
    private String tipoAcertijo;

    @Column
    private Float calificacion;

    //El peso debe regularse bien en el frontend, pues no puede ser cualquier valor loco
    // a la hora de crear el FRONTEND antes de enviar el formulario TODOS los acertijos deben estar creados
    // Si se cambia el peso debe actualizarse TODOS los pesos de cada acertijo
    // Debe haber una opción para escoger si cambiar el peso y por defecto todos los acertijos valen lo mismo
    // El peso es un valor que va de 0.01 a 1 representando el porcentaje
    @Column
    private Float peso;

    //Se refiere a la cantidad de respuestas correctas que hay, es 1 su es 'e' o 'sm' pero >1 si es 'mr'
    @Column
    private int cantidadCorrectas;

    @ManyToOne
    @JoinColumn (name = "nivel_id")
    private Nivel nivel;

    @OneToMany (mappedBy = "acertijo")
    private List<Respuesta> respuestas = new ArrayList<>();

    @OneToMany (mappedBy = "acertijo")
    private List <IntentoRespuesta> intentos = new ArrayList<>();


    public Acertijo(String nombre, String descripcion, Nivel nivel, String tipoAcertijo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.nivel = nivel;
        this.tipoAcertijo= tipoAcertijo;
    }

    public Acertijo() {
    }


    public int getCantidadCorrectas() {
        return cantidadCorrectas;
    }

    public void setCantidadCorrectas(int cantidadCorrectas) {
        this.cantidadCorrectas = cantidadCorrectas;
    }

    public String getTipoAcertijo() {
        return tipoAcertijo;
    }

    public void setTipoAcertijo(String tipoAcertijo) {
        this.tipoAcertijo = tipoAcertijo;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public List<IntentoRespuesta> getIntentos() {
        return intentos;
    }

    public void setIntentos(List<IntentoRespuesta> intentos) {
        this.intentos = intentos;
    }

    public Float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Float calificacion) {
        this.calificacion = calificacion;
    }

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

    public String getImagenAcertijo() {
        return imagenAcertijo;
    }

    public void setImagenAcertijo(String imagenAcertijo) {
        this.imagenAcertijo = imagenAcertijo;
    }

    public int getCantidadRespuestas() {
        return cantidadRespuestas;
    }

    public void setCantidadRespuestas(int cantidadRespuestas) {
        this.cantidadRespuestas = cantidadRespuestas;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }
}
