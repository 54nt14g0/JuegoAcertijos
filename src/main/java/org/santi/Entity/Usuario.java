package org.santi.Entity;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;
    @Column
    private LocalDate fechaNacimiento;
    @Column
    private String pass;

    @Column(unique = true)
    private String email;
    @Column
    private boolean admin;
    @Column
    private String progreso;

    @ManyToOne
    @JoinColumn(name = "juego_id")
    private Juego juego;

    @OneToMany (mappedBy = "intentoRespuesta")
    private List<IntentoRespuesta> intentos = new ArrayList<>();


    public Usuario(String nombre, String pass, String email, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.pass = pass;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Usuario() {

    }


    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public void setProgreso(String progreso) {
        this.progreso = progreso;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getPass() {
        return pass;
    }

    public String getEmail() {
        return email;
    }

    public boolean isAdmin() {
        return admin;
    }

    public String getProgreso() {
        return progreso;
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

}
