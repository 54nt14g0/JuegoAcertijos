package org.santi.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Nivel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Este atributo nombre es una especie de identificador del nivel para el progreso del jugador
    // Cuando un Usuario gana el nivel, se añade este nombre a la cadena progreso
    @Column (unique = true)
    private String nombre;

    @Column
    private String dificultad;
    @Column
    private String imagenFondo;
    @Column
    private String musicaNivel;
    @Column
    private String descripcion;

    @Column
    private int cantidadAcertijos;


    //Aquí va un string con los nombres de los niveles RQEUISITO para que este nivel pueda jugarse
    @Column
    private String requisitos;

    // Numero del 0.01 al 1 representando el porcentaje
    @Column
    private Float minimaCalificacionGanar;


    @ManyToOne
    @JoinColumn(name = "juego_id")
    private Juego juego;

    @OneToMany (mappedBy = "nivel")
    private List<Acertijo> acertijos = new ArrayList<>();


    public Nivel(String nombre, String dificultad, String descripcion, String requisitos, Float minimaCalificacionGanar, Juego juego) {
        this.nombre = nombre;
        this.dificultad = dificultad;
        this.descripcion = descripcion;
        this.requisitos = requisitos;
        this.minimaCalificacionGanar = minimaCalificacionGanar;
        this.juego = juego;
    }

    public Nivel() {
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public Float getMinimaCalificacionGanar() {
        return minimaCalificacionGanar;
    }

    public void setMinimaCalificacionGanar(Float minimaCalificacionGanar) {
        this.minimaCalificacionGanar = minimaCalificacionGanar;
    }


    public int getCantidadAcertijos() {
        return cantidadAcertijos;
    }

    public void setCantidadAcertijos(int cantidadAcertijos) {
        this.cantidadAcertijos = cantidadAcertijos;
    }

    public List<Acertijo> getAcertijos() {
        return acertijos;
    }

    public void setAcertijos(List<Acertijo> acertijos) {
        this.acertijos = acertijos;
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
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

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public String getImagenFondo() {
        return imagenFondo;
    }

    public void setImagenFondo(String imagenFondo) {
        this.imagenFondo = imagenFondo;
    }

    public String getMusicaNivel() {
        return musicaNivel;
    }

    public void setMusicaNivel(String musicaNivel) {
        this.musicaNivel = musicaNivel;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
