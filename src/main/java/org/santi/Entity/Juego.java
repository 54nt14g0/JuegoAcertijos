package org.santi.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Juego {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY )
    private Long id;
    @Column
    private String nombre;
    @Column
    private String fraseDelDia;
    @Column
    private String imagenDelDia;
    @Column
    private String musicaMenu;

    @OneToMany(mappedBy = "nivel")
    private List<Nivel> niveles = new ArrayList<>();

    @OneToMany (mappedBy = "usuario")
    private List <Usuario> usuarios = new ArrayList<>();




    public Juego(String nombre) {
        this.nombre = nombre;
    }

    public Juego() {

    }


    public List<Nivel> getNiveles() {
        return niveles;
    }

    public void setNiveles(List<Nivel> niveles) {
        this.niveles = niveles;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
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

    public String getFraseDelDia() {
        return fraseDelDia;
    }

    public void setFraseDelDia(String fraseDelDia) {
        this.fraseDelDia = fraseDelDia;
    }

    public String getImagenDelDia() {
        return imagenDelDia;
    }

    public void setImagenDelDia(String imagenDelDia) {
        this.imagenDelDia = imagenDelDia;
    }

    public String getMusicaMenu() {
        return musicaMenu;
    }

    public void setMusicaMenu(String musicaMenu) {
        this.musicaMenu = musicaMenu;
    }
}
