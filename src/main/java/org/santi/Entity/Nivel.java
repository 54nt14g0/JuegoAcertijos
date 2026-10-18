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
    private String Calificacion;

    //Aquí va un string con los nombres de los niveles RQEUISITO para que este nivel pueda jugarse
    @Column
    private String requisitos;

    @Column
    private Long minimaCalificacionGanar;

    // Este atributo determina si el Nivel hace parte de la secuencia o es aparte
    @Column
    private boolean isProgress;

    @ManyToOne
    @JoinColumn(name = "juego_id")
    private Juego juego;

    @OneToMany (mappedBy = "acertijo")
    private List<Acertijo> acertijos = new ArrayList<>();


    public Nivel(String nombre, String dificultad, String descripcion, Juego juego, boolean isProgress) {
        this.nombre = nombre;
        this.dificultad = dificultad;
        this.descripcion = descripcion;
        this.juego = juego;
        this.isProgress = isProgress;
    }

    public Nivel() {
    }

    public Long getMinimaCalificacionGanar() {
        return minimaCalificacionGanar;
    }

    public void setMinimaCalificacionGanar(Long minimaCalificacionGanar) {
        this.minimaCalificacionGanar = minimaCalificacionGanar;
    }

    public String getCalificacion() {
        return Calificacion;
    }

    public void setCalificacion(String calificacion) {
        Calificacion = calificacion;
    }

    public boolean isProgress() {
        return isProgress;
    }

    public void setProgress(boolean progress) {
        isProgress = progress;
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
