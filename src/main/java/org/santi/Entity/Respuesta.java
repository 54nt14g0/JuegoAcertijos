package org.santi.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Respuesta {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;


    @Column
    private String descripcion;

    @Column
    private String imagenRespuesta;


    @Column
    private String respuestaCorrecta;

    // Esto se refiere a si es la respuesta 'a' o 'b' por ejemplo
    @Column
    private String nombre;

    @ManyToOne
    @JoinColumn (name = "acertijo_id")
    private Acertijo acertijo;

    @OneToMany (mappedBy = "intentoRespuesta")
    private List<IntentoRespuesta> intentos = new ArrayList<>();


    public Respuesta(Acertijo acertijo, String nombre, String respuestaCorrecta, String descripcion) {
        this.acertijo = acertijo;
        this.nombre = nombre;
        this.respuestaCorrecta = respuestaCorrecta;
        this.descripcion = descripcion;
    }

    public Respuesta( String descripcion, String nombre, Acertijo acertijo) {

        this.descripcion = descripcion;
        this.nombre = nombre;
        this.acertijo = acertijo;
    }

    public Respuesta() {
    }


    public List<IntentoRespuesta> getIntentos() {
        return intentos;
    }

    public void setIntentos(List<IntentoRespuesta> intentos) {
        this.intentos = intentos;
    }

    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(String respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagenRespuesta() {
        return imagenRespuesta;
    }

    public void setImagenRespuesta(String imagenRespuesta) {
        this.imagenRespuesta = imagenRespuesta;
    }

    public Acertijo getAcertijo() {
        return acertijo;
    }

    public void setAcertijo(Acertijo acertijo) {
        this.acertijo = acertijo;
    }
}
