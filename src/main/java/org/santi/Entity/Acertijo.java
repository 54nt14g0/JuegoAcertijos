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
    private Float calificacion;

    @ManyToOne
    @JoinColumn (name = "nivel_id")
    private Nivel nivel;

    @OneToMany (mappedBy = "respuesta")
    private List<Respuesta> respuestas = new ArrayList<>();

    @OneToMany (mappedBy = "intentoRespuesta")
    private List <IntentoRespuesta> intentos = new ArrayList<>();


    public Acertijo(String nombre, String descripcion, Nivel nivel) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.nivel = nivel;
    }

    public Acertijo() {
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
